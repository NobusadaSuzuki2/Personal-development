package ec;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class DestroyServlet
 */
@WebServlet("/DestroyServlet")
public class DestroyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DestroyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();

		//ユーザーがログインしているか確認
		Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

		//ログインしていない場合
		if (!isLogin) {
			// Sessionにリターンページ情報を書き込む
			//session.setAttribute("returnStrUrl", "Buy");
			// Login画面にリダイレクト
			response.sendRedirect("LoginServlet");
		} else {
			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			try {
				//idを引数にして、idに紐づくユーザ情報を出力する
				ItemDataBeans itemid = ItemDAO.getItemByItemID(id);

				// ユーザ情報をリクエストスコープにセットしてjspにフォワード
				request.setAttribute("itemid", itemid);

				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/destroy.jsp");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// hiddenがついたインプットのformからIDパラメータを受け取る
		String id = request.getParameter("id");

		try {
			//idを引数にして、idに紐づくユーザ情報を出力する
			ItemDAO itemDao = new ItemDAO();
			itemDao.ItemDestroy(id);
		} catch (NullPointerException e) {
			e.printStackTrace();
			// 削除jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/destroy.jsp");
			dispatcher.forward(request, response);
		}
		// ユーザ一覧のサーブレットにリダイレクト
		response.sendRedirect("AdminInfoServlet");
		return;
	}

}
