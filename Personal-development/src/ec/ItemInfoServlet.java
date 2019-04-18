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
import dao.ItemDAO;

/**
 * Servlet implementation class ItemInfoServlet
 */
@WebServlet("/ItemInfoServlet")
public class ItemInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpSessionインスタンスの取得
				HttpSession session = request.getSession();
				// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("id");
				try {
					//idを引数にして、idに紐づくユーザ情報を出力する
					ItemDataBeans itemInfo = ItemDAO.getItemByItemID(id);

					// ユーザ情報をリクエストスコープにセットしてjspにフォワード
					request.setAttribute("itemInfo", itemInfo);

					// フォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemInfo.jsp");
					dispatcher.forward(request, response);
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
