package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fbd.acad.entidade.Empresa;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoEmpresa implements IDaoEmpresa {
	
	private Connection conexao;
	private PreparedStatement statement;

	@Override
	public boolean cadastrar(Empresa empresa) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Empresa.INSERT_ALL);
			
			statement.setString(1, empresa.getNome());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Empresa empresa) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Empresa.UPDATE_ALL);
			
			statement.setString(1, empresa.getNome());
			statement.setInt(2, empresa.getId());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
