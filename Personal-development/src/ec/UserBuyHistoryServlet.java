package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import dao.BuyDAO;

/**
 * Servlet implementation class UserBuyHistoryServlet
 */
@WebServlet("/UserBuyHistoryServlet")
public class UserBuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserBuyHistoryServlet() {
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
			// ログイン時に取得したユーザーIDをセッションから取得
			int userId = (int) session.getAttribute("userId");

			//インスタンスを生成し、購入情報を取得
			ArrayList<BuyDataBeans> bdbList = new ArrayList<BuyDataBeans>();
			bdbList = BuyDAO.getBuyDataBeansUserIdBuyId(userId);
			session.setAttribute("bdbList", bdbList);

			//フォワード
			request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_PAGE).forward(request, response);
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
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// ログイン時に取得したユーザーIDをセッションから取得
		int userId = (int) session.getAttribute("userId");

		String buyDay = request.getParameter("buyDay");
		String buyDay2 = request.getParameter("buyDay2");

		ArrayList<BuyDataBeans> bdbList = BuyDAO.getBuyDstaInfo(buyDay, buyDay2,userId);
		request.setAttribute("bdbList", bdbList);

		//フォワード
		request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_PAGE).forward(request, response);
	}

}
