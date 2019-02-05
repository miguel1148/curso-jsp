package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.BeanCursoJSP;
import connection.SingleConnection;

public class DaoUsuario {

	private Connection connection;
	
	public DaoUsuario() {
		connection= SingleConnection.getConnection();
	}
	
	public void salvar(BeanCursoJSP usuario) {
		
		try {
			String sql = "insert into usuario(login, senha) values(?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.execute();
			connection.commit();
			
		} catch (Exception e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
}
