package ec;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AdminInfoServlet
 */
@WebServlet("/AdminInfoServlet")
public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminInfoServlet() {
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

		// 商品一覧情報を(DAOを使って)取得
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemList = itemDao.findAll();

		// リクエストスコープに商品情報(itemListと言う情報)をセット(インスタンスを保存)
		request.setAttribute("itemList", itemList);
		// 管理者画面のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminInfo.jsp");
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
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String itemName = request.getParameter("itemName");
		String createDate = request.getParameter("createDate");
		String createDate2 = request.getParameter("createDate2");

		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemList = itemDao.getItemsInfo(itemName,createDate,createDate2);
		// リクエストスコープに商品情報(itemListと言う情報)をセット(インスタンスを保存)
		request.setAttribute("itemList", itemList);

		// 管理者画面のjspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/adminInfo.jsp");
		dispatcher.forward(request, response);

	}

}
