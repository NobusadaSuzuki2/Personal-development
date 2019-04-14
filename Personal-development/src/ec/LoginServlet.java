package ec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		//ログイン失敗時に使用するため
		String inputLoginId = session.getAttribute("loginId") != null
				? (String) EcHelper.cutSessionAttribute(session, "loginId")
				: "";
		String loginErrorMessage = (String) EcHelper.cutSessionAttribute(session, "loginErrorMessage");

		request.setAttribute("inputLoginId", inputLoginId);
		request.setAttribute("loginErrorMessage", loginErrorMessage);

		request.getRequestDispatcher(EcHelper.LOGIN_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		try {
			//パラメーターから取得
			String loginId = request.getParameter("login_id");
			String password = request.getParameter("password");

			//ユーザーIDを取得
			int userId = UserDAO.getUserId(loginId, password);

			//ユーザーIDが取得できたなら
			if (userId != 0) {
				session.setAttribute("isLogin", true);
				session.setAttribute("userId", userId);

				if (loginId.equals("admin")) {
					/*// 管理者jspにフォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("AdminInfoServlet");
					dispatcher.forward(request, response);*/

					//管理者JSPにリダイレクト
					response.sendRedirect("AdminInfoServlet");
					return;
				}
				//ログイン前のページを取得
				String returnStrUrl = (String) EcHelper.cutSessionAttribute(session, "returnStrUrl");
				//ログイン前ページにリダイレクト。指定がない場合Index
				response.sendRedirect(returnStrUrl != null ? returnStrUrl : "IndexServlet");
			} else {
				session.setAttribute("loginId", loginId);
				session.setAttribute("loginErrorMessage", "入力内容が正しくありません");
				response.sendRedirect("LoginServlet");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
