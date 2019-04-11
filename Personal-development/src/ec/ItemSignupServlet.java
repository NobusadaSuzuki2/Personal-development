package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemSignupServlet
 */
@WebServlet("/ItemSignupServlet")
public class ItemSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemSignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// ユーザ一覧のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemSignup.jsp");
		dispatcher.forward(request, response);
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
		try {
			if (itemName.equals("") || itemPrice.equals("") || detail.equals("") || datafile.equals("")) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "未入力の欄があります");
				// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemSignup.jsp");
				dispatcher.forward(request, response);
				return;
			}
			ItemDataBeans Idb = new ItemDataBeans();
			Idb.setName(itemName);
			Idb.setPrice(Integer.parseInt(itemPrice));
			Idb.setDetail(detail);
			Idb.setFileName(datafile);
			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行

			ItemDAO.setItemSignup(Idb);

			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("AdminInfoServlet");
			return;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
