package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//ログイン情報を登録してます。
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User user = new User(name, pass);

		LoginLogic loginLogic = new LoginLogic();
		boolean isLogic = loginLogic.execute(user);

		//きちんと登録してればセッションを用いてセットしてます。
		if(isLogic) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

		}

		//ログイン結果画面に移ります。
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		dis.forward(request, response);
	}

}
