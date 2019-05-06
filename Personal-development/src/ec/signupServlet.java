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

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class signupServlet
 */
@WebServlet("/signupServlet")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public signupServlet() {
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


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
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
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String user_name = request.getParameter("user_name");
		String address = request.getParameter("address");

		try {
		// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		boolean user = UserDAO.isOverlapLoginId(loginId,0);
		//loginIdがすでに存在していた場合
		if (user == true) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "このログインIDは既に使われています");
			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (loginId.equals("") || password.equals("") || password2.equals("") || user_name.equals("")
				|| address.equals("")) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "未入力の欄があります");
			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		} else if (password.equals(password2)) {

			UserDataBeans udb = new UserDataBeans();
			udb.setName(user_name);
			udb.setAddress(address);
			udb.setLoginId(loginId);
			udb.setPassword(password);
			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserDAO.insertUser(udb);

			// 商品一覧のサーブレットにリダイレクト
			response.sendRedirect("IndexServlet");
			return;

		} else {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "確認用パスワードが異なります");

			// 新規登録jspにフォワード(失敗した時に元の画面に戻る)
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
