package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJSP;
import dao.DaoUsuario;


@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoUsuario daoUsuario = new DaoUsuario();
	
    public Usuario() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
     
		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(user);
				RequestDispatcher view = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			
			}else if(acao.equalsIgnoreCase("editar")) {
				BeanCursoJSP bean = daoUsuario.consultar(user);
				RequestDispatcher view = request
						.getRequestDispatcher("/cadastroUsuario.jsp");
				request.setAttribute("user", bean);
				view.forward(request, response);
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BeanCursoJSP usuario = new BeanCursoJSP();
		usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if(id == null || id.isEmpty()) {
			daoUsuario.salvar(usuario);
		}else {
			daoUsuario.atualizar(usuario);
		}
		
		
		try {
			RequestDispatcher view = request
					.getRequestDispatcher("/cadastroUsuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
