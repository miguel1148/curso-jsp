package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJSP;
import dao.DaoLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoLogin daoLogin = new DaoLogin();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// OBS: Todo formulario enviado � uma requisi��o

		try {
			BeanCursoJSP bean = new BeanCursoJSP();

			String login = request.getParameter("Login");
			String senha = request.getParameter("Senha");

			if (daoLogin.validarLogin(login, senha)) {// Acesso OK.
				RequestDispatcher dispatcher = request.getRequestDispatcher("acessoliberado.jsp");
				dispatcher.forward(request, response);
			} else {// Acesso NEGADO
				RequestDispatcher dispatcher = request.getRequestDispatcher("acessonegado.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
	//		e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}
