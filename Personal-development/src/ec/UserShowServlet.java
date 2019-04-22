package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class UserShowServlet
 */
@WebServlet("/UserShowServlet")
public class UserShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserShowServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//セッション開始
		HttpSession session = request.getSession();

		//更新失敗時に使用するため
				String validationMessage = (String) EcHelper.cutSessionAttribute(session, "validationMessage");
				//エラーメッセージセット
				request.setAttribute("validationMessage", validationMessage);
		try {
			// ログイン時に取得したユーザーIDをセッションから取得
			int userId = (int) session.getAttribute("userId");
			//ユーザー情報を取得
			UserDataBeans udb = UserDAO.getUserDataBeansByUserId(userId);

			//ユーザー情報をセットしてフォワード
			request.setAttribute("udb", udb);
			request.getRequestDispatcher(EcHelper.USER_SHOW_PAGE).forward(request, response);
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

		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//セッション開始
		HttpSession session = request.getSession();
		try {
			UserDataBeans udb = new UserDataBeans();
			udb.setUpdateUserDataBeansInfo(request.getParameter("userName"), request.getParameter("loginId"),
					request.getParameter("address"), (int) session.getAttribute("userId"));

			//エラーメッセージを格納する変数
			String validationMessage = "";

			//ログインIDの入力規則チェック 英数字 ハイフン アンダースコアのみ入力可能
			if (!EcHelper.isLoginIdValidation(udb.getLoginId())) {
				validationMessage = "半角英数とハイフン、アンダースコアのみ入力できます";
			}
			//loginIdの重複をチェック
			if (UserDAO.isOverlapLoginId(udb.getLoginId(), (int) session.getAttribute("userId"))) {
				validationMessage = "ほかのユーザーが使用中のログインIDです";
			}
			//バリデーションエラーメッセージがないなら確認画面へ
			if (validationMessage.length() == 0) {
				// アップデート処理
				UserDAO.updateUser(udb);
				request.setAttribute("udb", udb);
				request.getRequestDispatcher(EcHelper.USER_SHOW_PAGE).forward(request, response);
			} else {
				//セッションにエラーメッセージを持たせてユーザー画面へ
				session.setAttribute("validationMessage", validationMessage);
				response.sendRedirect("UserShowServlet");
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
