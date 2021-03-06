package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBManager;
import dto.ShoutDTO;

/**
 * Servlet implementation class messagedelete2
 */
@WebServlet("/MessageDeleteResult")
public class MessageDeleteResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageDeleteResult() {
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
	 * メッセージ削除　結果　再更新処理
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = null;
		String[] number = request.getParameterValues("number");
		DBManager dbm = new DBManager();
		if (number != null) {
			List<String> info = Arrays.asList(number);
			for (int i = 0; i < info.size(); i++) {
				String as = info.get(i);
				dbm.getShoutList３(as);
			}
		ArrayList<ShoutDTO> list = dbm.getShoutList();
		HttpSession session = request.getSession();
		//top.jspフォワードへshoutセッションアップデート（削除後）
		session.setAttribute("shouts", list);
		// 処理の転送先を top.jsp に指定
		dispatcher = request.getRequestDispatcher("top.jsp");
		// 処理を転送
		dispatcher.forward(request, response);
	}
	}
}


