package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;
import beans.StockDataBeans;
import dao.ItemDAO;
import dao.StockDAO;

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
		HttpSession session = request.getSession();
		try {
			boolean login = (boolean) session.getAttribute("isLogin");

			if (login != true) {
				//login画面にリダイレクト
				response.sendRedirect("LoginServlet");
				return;
			}
			// 商品登録のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemSignup.jsp");
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
		String stock = request.getParameter("stock");
		try {
			if (itemName.equals("") || itemPrice.equals("") || detail.equals("") || datafile.equals("")|| stock.equals("")) {
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

			int itemId = ItemDAO.setItemSignup(Idb);
			StockDataBeans sdb = new StockDataBeans();
			sdb.setStock(Integer.parseInt(stock));
			sdb.setItemId(itemId);
			StockDAO.setStockInfo(sdb);

			// 管理者画面のサーブレットにリダイレクト
			response.sendRedirect("AdminInfoServlet");
			return;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
