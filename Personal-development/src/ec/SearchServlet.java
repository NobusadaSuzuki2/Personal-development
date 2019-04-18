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
 * Servlet implementation class IndexServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();
		try {
			ArrayList<ItemDataBeans> itemList = ItemDAO.getRandItem(8);
			// ユーザ情報をリクエストスコープにセットしてjspにフォワード
			request.setAttribute("itemList", itemList);
			//1ページに表示する商品数
			int maxItem = 8;

			//jspからsearchをパラメーターで取得
			String search = request.getParameter("search");
			//表示ページ番号 未指定の場合 1ページ目を表示
			int pageNum = Integer
					.parseInt(request.getParameter("page_num") == null ? "1" : request.getParameter("page_num"));
			// 新たに検索されたキーワードをセッションに格納する
			session.setAttribute("search", search);

			//検索されたキーワードを元にデータを取得
			ArrayList<ItemDataBeans> itemSearch = ItemDAO.getItemsByItemName(search, pageNum, maxItem);

			// 検索ワードに対しての総ページ数を取得
			double itemCount = ItemDAO.getItemCount(search);
			int pageMax = (int) Math.ceil(itemCount / maxItem);

			//リクエストスコープにセット
			//総アイテム数
			request.setAttribute("itemCount", (int) itemCount);
			// 総ページ数
			request.setAttribute("pageMax", pageMax);
			// 表示ページ
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("itemList", itemSearch);

			// 商品一覧のjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

}
