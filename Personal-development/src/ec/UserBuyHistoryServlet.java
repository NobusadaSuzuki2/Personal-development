package ec;

import java.io.IOException;
import java.sql.SQLException;
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
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();
		// ログイン時に取得したユーザーIDをセッションから取得
		int userId = (int) session.getAttribute("userId");
		try {
			//インスタンスを生成し、購入情報を取得
			ArrayList<BuyDataBeans> bdbList = new ArrayList<BuyDataBeans>();
			bdbList = BuyDAO.getBuyDataBeansUserIdBuyId(userId);
			session.setAttribute("bdbList", bdbList);

			//フォワード
			request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_PAGE).forward(request, response);
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

		//フォワード
		request.getRequestDispatcher(EcHelper.USER_BUY_HISTORY_PAGE).forward(request, response);
	}

}
