package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fbd.acad.entidade.Categoria;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoCategoria implements IDaoCategoria{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public boolean cadastrar(Categoria categoria) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Categoria.INSERT_ALL);
			
			statement.setString(1, categoria.getCategoria());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Categoria categoria) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Categoria.UPDATE_ALL);
			
			statement.setString(1, categoria.getCategoria());
			statement.setInt(2, categoria.getId());
			
			statement.execute();
			
			statement.close();
			conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean validar_nome(String nome) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Categoria.SELECT_NOME);
			
			statement.setString(1, nome);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				statement.close();
				conexao.close();
				result.close();
				return false;
			}
			statement.close();
			conexao.close();
			result.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Categoria> getList() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Categoria.SELECT_ALL);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				Categoria categoria = new Categoria(result.getInt("id"), result.getString("categoria"));
				categorias.add(categoria);
				
			}
			conexao.close();
			statement.close();
			result.close();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categorias;
	}

}
