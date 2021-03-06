package controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class messageupdate3
 */
@WebServlet("/MessageUpdateresult")
public class MessageUpdateresult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageUpdateresult() {
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
	 * メッセージ編集結果　メッセージの再アップデート
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = null;
		DBManager dbm = new DBManager();
		ArrayList<ShoutDTO> list = dbm.getShoutList();
		HttpSession session = request.getSession();
		String message = "コメントの編集、削除できます。";
		//top,jsp sessionをアップデート
		session.setAttribute("shouts", list);
		// 処理の転送先を top.jsp に指定
		dispatcher = request.getRequestDispatcher("top.jsp");
		dispatcher.forward(request, response);

	}

}
