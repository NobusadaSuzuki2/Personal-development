package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.DeliveryMethodDAO;
import dao.UserDAO;

/**
 * Servlet implementation class BuyConfirmServlet
 */
@WebServlet("/BuyConfirmServlet")
public class BuyConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuyConfirmServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッションを作成
		HttpSession session = request.getSession();
		try {
			// ログイン時に取得したユーザーIDをセッションから取得
			int userId = (int) session.getAttribute("userId");
			// 更新確認画面から戻ってきた場合Sessionから取得。それ以外はuserIdでユーザーを取得
			UserDataBeans udb = session.getAttribute("returnUDB") == null ? UserDAO.getUserDataBeansByUserId(userId)
					: (UserDataBeans) EcHelper.cutSessionAttribute(session, "returnUDB");

			// 入力された内容に誤りがあったとき等に表示するエラーメッセージを格納する
			String validationMessage = (String) EcHelper.cutSessionAttribute(session, "validationMessage");

			//リクエストパラメーターにセット
			request.setAttribute("validationMessage", validationMessage);
			request.setAttribute("udb", udb);

			//選択された配送方法IDを取得
			int inputDeliveryMethodId = Integer.parseInt(request.getParameter("delivery_method_id"));
			//選択されたIDをもとに配送方法Beansを取得
			DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO
					.getDeliveryMethodDataBeansByID(inputDeliveryMethodId);

			//買い物かご
			ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			//合計金額
			int totalItemPrice = EcHelper.getTotalItemPrice(cartIDBList);
			int totalPrice = totalItemPrice + userSelectDMB.getPrice();

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setUserId((int) session.getAttribute("userId"));
			bdb.setTotalPrice(totalPrice);
			bdb.setDelivertMethodId(userSelectDMB.getId());
			bdb.setDeliveryMethodName(userSelectDMB.getName());
			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());

			//購入確定で利用
			request.setAttribute("bdb", bdb);
			//フォワード
			request.getRequestDispatcher(EcHelper.BUY_CONFIRM_PAGE).forward(request, response);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
