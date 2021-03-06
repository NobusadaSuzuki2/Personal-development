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
import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			boolean login = (boolean) session.getAttribute("isLogin");

			if (login != true) {
				//login画面にリダイレクト
				response.sendRedirect("LoginServlet");
				return;
			}

			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemDataBeans>();
				session.setAttribute("cart", cart);
			}

			String cartActionMessage = "";
			//カートに商品が入っていないなら
			if (cart.size() == 0) {
				cartActionMessage = "カートに商品がありません";
			}

			//合計金額
			int totalItemPrice = EcHelper.getTotalItemPrice(cart);
			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setTotalPrice(totalItemPrice);

			//合計金額を更新
			session.setAttribute("bdb", bdb);

			request.setAttribute("cartActionMessage", cartActionMessage);
			request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);

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
		HttpSession session = request.getSession();
		try {
			boolean login = (boolean) session.getAttribute("isLogin");

			if (login != true) {
				//login画面にリダイレクト
				response.sendRedirect("LoginServlet");
				return;
			}
			//選択された商品のIDを型変換し利用
			int id = Integer.parseInt(request.getParameter("item.id"));
			//対象のアイテム情報を取得
			ItemDataBeans item = ItemDAO.getItemByItemID(id);

			//追加した商品を表示するためリクエストパラメーターにセット
			request.setAttribute("item", item);

			//カートを取得
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			//セッションにカートがない場合カートを作成
			if (cart == null) {
				cart = new ArrayList<ItemDataBeans>();
			}
			//カートに商品を追加。
			cart.add(item);

			//合計金額
			int totalItemPrice = EcHelper.getTotalItemPrice(cart);
			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setTotalPrice(totalItemPrice);

			//合計金額を更新
			session.setAttribute("bdb", bdb);
			//カート情報更新
			session.setAttribute("cart", cart);
			request.setAttribute("cartActionMessage", "商品を追加しました");

			request.getRequestDispatcher(EcHelper.CART_PAGE).forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("LoginServlet");
		}
	}

}
