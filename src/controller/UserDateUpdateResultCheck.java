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
import dto.UserDTO;

/**
 * Servlet implementation class UserUpdeta4
 */
@WebServlet("/UserDateUpdateResultCheck")
public class UserDateUpdateResultCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDateUpdateResultCheck() {
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
	 * ユーザー編集結果　遷移
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset=UTF-8");
		String loginId = request.getParameter("loginId");
		String password=request.getParameter("password");
		HttpSession session = request.getSession();
		String myName = (String) session.getAttribute("name");
		RequestDispatcher dispatcher = null;
		DBManager dbm = new DBManager();
		UserDTO user = dbm.getLoginUser(loginId, password);
		ArrayList<ShoutDTO> list = dbm.getShoutList();
		session.setAttribute("shouts", list);
		if (loginId.equals(myName)) {
			// ログインユーザ情報、書き込み内容リストとしてセッションに保存
			session.setAttribute("user", user);
			// 処理の転送先を top.jsp に指定
			dispatcher = request.getRequestDispatcher("top.jsp");
		} else {
			// 処理の転送先を top.jsp に指定
			dispatcher = request.getRequestDispatcher("top.jsp");

		}

		// 処理を転送
		dispatcher.forward(request, response);

	}
}
