package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<BeanCursoJSP> listar() throws SQLException, Exception{
		
		List<BeanCursoJSP> lista = new ArrayList<BeanCursoJSP>();
		
		String sql = "select * from usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			
			BeanCursoJSP bean = new BeanCursoJSP();
			bean.setId(resultSet.getLong("id"));
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			
			lista.add(bean);
		}
		return lista;
	}
	
	public void delete(String login)  {
		try {
		String sql = "delete from usuario where login = " +"'"+ login + "'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute();
		
		connection.commit();
		//SQLException
		}catch(Exception e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
	}
	
	
	public BeanCursoJSP consultar(String login) throws SQLException {
		String sql = "select * from usuario where login = " +"'"+ login +"'"; 
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		ResultSet resultSet = prepareStatement.executeQuery();
		if(resultSet.next()) {
			
			BeanCursoJSP bean = new BeanCursoJSP();
			bean.setId(resultSet.getLong("id"));
			bean.setLogin(resultSet.getString("login"));
			bean.setSenha(resultSet.getString("senha"));
			return bean;
		}
		return null;
		
	}

	public void atualizar(BeanCursoJSP usuario) {

		try {
			String sql = "update usuario set login = ?, senha = ? where id = " + "'" + usuario.getId() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	
	
	
	
	
	
	
	
}
