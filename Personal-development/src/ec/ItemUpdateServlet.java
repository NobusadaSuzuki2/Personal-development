package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemUpdateServlet
 */
@WebServlet("/ItemUpdateServlet")
public class ItemUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemUpdateServlet() {
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

			//ユーザーがログインしているか確認
			Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin")
					: false;
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");

			//idを引数にして、idに紐づくユーザ情報を出力する
			ItemDataBeans itemid = ItemDAO.getItemByItemID(id);

			// ユーザ情報をリクエストスコープにセットしてjspにフォワード
			request.setAttribute("itemid", itemid);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemUpdate.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
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
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String detail = request.getParameter("detail");
		String datafile = request.getParameter("datafile");
		String id = request.getParameter("id");

		//ファイルが読み込まれなかった場合
		if (datafile.equals("")) {
			//idを引数にして、idに紐づく商品情報を出力する
			ItemDAO itemDao = new ItemDAO();
			itemDao.itemUpdate(itemName, itemPrice, detail, id);
			// 商品一覧のサーブレットにリダイレクト
			response.sendRedirect("AdminInfoServlet");
			return;
		} else {
			//idを引数にして、idに紐づく商品情報を出力する
			ItemDAO itemDao = new ItemDAO();
			itemDao.itemUpdate(itemName, itemPrice, detail, datafile, id);
			// 商品一覧のサーブレットにリダイレクト
			response.sendRedirect("AdminInfoServlet");
			return;
		}
	}

}
