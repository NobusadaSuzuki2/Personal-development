package ec;

import java.io.IOException;

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
 * Servlet implementation class showServlet
 */
@WebServlet("/showServlet")
public class showServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showServlet() {
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
			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			//idを引数にして、idに紐づくユーザ情報を出力する
			ItemDataBeans itemInfo = ItemDAO.getItemByItemID(id);

			// ユーザ情報をリクエストスコープにセットしてjspにフォワード
			request.setAttribute("itemInfo", itemInfo);

			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemInfo.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("LoginServlet");
		}

	}

}
