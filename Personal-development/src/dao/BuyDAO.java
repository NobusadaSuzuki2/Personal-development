package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDataBeans;

/**
 *
 * @author d-yamaguchi
 *
 */
public class BuyDAO {

	/**
	 * 購入情報登録処理
	 * @param bdb 購入情報
	 * @throws SQLException 呼び出し元にスローさせるため
	 */
	public static int insertBuy(BuyDataBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_buy(user_id,total_price,delivery_method_id,create_date) VALUES(?,?,?,now())",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getUserId());
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDelivertMethodId());
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

			return autoIncKey;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BuyDataBeans
	 * 				購入情報のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */
	public static BuyDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy JOIN m_delivery_method ON t_buy.delivery_method_id = m_delivery_method.id WHERE t_buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyDataBeans bdb = new BuyDataBeans();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getDate("create_date"));
				bdb.setDelivertMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));
			}

			System.out.println("searching BuyDataBeans by buyID has been completed");

			return bdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	//ユーザーIDによる購入情報List検索
	public static ArrayList<BuyDataBeans> getBuyDataBeansUserIdBuyId(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy "
							+ "JOIN m_delivery_method "
							+ "ON t_buy.delivery_method_id = m_delivery_method.id "
							+ "WHERE t_buy.user_id = ?");
			st.setInt(1, userId);

			//ResultSet rs = st.executeQuery();

			//BuyDataBeans bdb = new BuyDataBeans();

			ResultSet rs = st.executeQuery();
			ArrayList<BuyDataBeans> buyDetailItemList = new ArrayList<BuyDataBeans>();

			while (rs.next()) {
				BuyDataBeans bdb = new BuyDataBeans();
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getDate("create_date"));
				bdb.setDelivertMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));

				buyDetailItemList.add(bdb);
			}

			/*while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));

				buyDetailItemList.add(idb);
			}*/

			System.out.println("searching BuyDataBeans by userID has been completed");

			return buyDetailItemList;
			//return bdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<BuyDataBeans> getBuyDstaInfo(String createDate, String createDate2, int userId) {
		Connection conn = null;
		ArrayList<BuyDataBeans> itemList = new ArrayList<BuyDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM t_buy JOIN `t_buy_detail` ON t_buy.id = t_buy_detail.`buy_id` "
					+ "WHERE user_id = 5";

			if (!createDate.equals("")) {
				sql += " AND create_date >= '" + createDate + "'";

			} else {
				if (!createDate2.equals("")) {
					sql += " AND create_date <= '" + createDate2 + "'";
				}
			}
			System.out.println(sql);

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 必要なデータのみインスタンスのフィールドに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				int user_id = rs.getInt("user_id");
				int totalPrice = rs.getInt("total_price");
				int delivertMethodId = rs.getInt("delivery_method_id");
				Date buyDate = rs.getDate("create_date");
				BuyDataBeans item = new BuyDataBeans(id, user_id, totalPrice, delivertMethodId, buyDate);

				itemList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return itemList;
	}

}
