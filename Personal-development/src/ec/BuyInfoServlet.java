package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.BuyDAO;
import dao.ItemDAO;
import dao.UserDAO;

/**
 * Servlet implementation class BuyInfoServlet
 */
@WebServlet("/BuyInfoServlet")
public class BuyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		try {
			boolean login = (boolean) session.getAttribute("isLogin");

			if (login != true) {
				//login画面にリダイレクト
				response.sendRedirect("LoginServlet");
				return;
			}

			//セッションからユーザーIdを取得
			int userId = (int) session.getAttribute("userId");
			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			int buyId = Integer.parseInt(id);

			//インスタンスを生成し、ユーザー情報を取得、セット
			UserDataBeans udb = UserDAO.getUserDataBeansByUserId(userId);
			request.setAttribute("udb", udb);

			//インスタンスを生成し、購入情報を取得、セット
			BuyDataBeans bdb = BuyDAO.getBuyDataBeansByBuyId(buyId);
			request.setAttribute("bdb", bdb);

			//インスタンスを生成し、アイテム情報を取得、セット
			ArrayList<ItemDataBeans> itemList = ItemDAO.getItemBybuyId(buyId);
			request.setAttribute("itemList", itemList);

			//フォワード
			request.getRequestDispatcher(EcHelper.BUY_INFO_PAGE).forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("LoginServlet");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
