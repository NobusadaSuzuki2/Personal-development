package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import base.DBManager;
import beans.StockDataBeans;

public class StockDAO {

	public static void setStockInfo(StockDataBeans sdb){

		Connection con = null;
		PreparedStatement st = null;

		con = DBManager.getConnection();

		try {
			st = con.prepareStatement("INSERT INTO stock(stock,item_id) VALUES(?,?)");

			st.setInt(1, sdb.getStock());
			st.setInt(2, sdb.getItemId());
			st.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
