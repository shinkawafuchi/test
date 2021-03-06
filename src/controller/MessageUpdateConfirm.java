package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;

/**
 * Servlet implementation class messageupdate2
 */
@WebServlet("/MessageUpdateConfirm")
public class MessageUpdateConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageUpdateConfirm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * メッセージ編集結果処理　エラー精査
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String writing = request.getParameter("writing");
		String icon = request.getParameter("icon");
		String userName = request.getParameter("userName");
		String back = request.getParameter("back");
		String date = request.getParameter("date");
		String number = request.getParameter("number");
		RequestDispatcher dispatcher = null;
		if (back != null) {
			//メッセージ送信
			String message = "コメントを編集してくだい。（そのほかはできません。）";
			request.setAttribute("alert", message);
			HttpSession session = request.getSession();
			//戻る処理、セッションにwritingを送信（メッセージ編集登録画面遷移）
			session.setAttribute("writing", writing);
			dispatcher = request.getRequestDispatcher("MessageUpdateInputReturn.jsp");
			dispatcher.forward(request, response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("writing", writing);
			session.setAttribute("userName", userName);
			session.setAttribute("date", date);
			session.setAttribute("icon", icon);
			session.setAttribute("number", number);
			DBManager dbm = new DBManager();
			dbm.getShoutList2(writing, number);
			//セッションにデータを送信
			//sql 編集処理（Update）
			dispatcher = request.getRequestDispatcher("MessageUpdateResult.jsp");
			dispatcher.forward(request, response);
		}
	}

}
