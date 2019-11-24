package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fbd.acad.entidade.Cargo;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoCargo implements IDaoCargo {
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public boolean cadastrar(Cargo cargo) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cargo.INSERT_ALL);
			
			statement.setString(1, cargo.getCargo());
	
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Cargo cargo) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cargo.UPDATE_ALL);
			
			statement.setString(1, cargo.getCargo());
			statement.setInt(2, cargo.getId());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
		
	}

	@Override
	public boolean validar_nome(String nome) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cargo.SELECT_NOME);
			
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
		}return true;
	}

	@Override
	public List<Cargo> getList() {
		List<Cargo> cargos = new ArrayList<Cargo>();
		
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cargo.SELECT_ALL);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				Cargo cargo = new Cargo(result.getInt("id"), result.getString("cargo"));
				cargos.add(cargo);			
			}
			statement.close();
			conexao.close();
			result.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cargos;
	}

}
