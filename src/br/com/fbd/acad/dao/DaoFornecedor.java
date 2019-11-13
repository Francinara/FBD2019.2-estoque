package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fbd.acad.entidade.Fornecedor;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoFornecedor implements IDaoFornecedor{
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public boolean cadastrar(Fornecedor fornecedor) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.INSERT_ALL);
			
			statement.setString(1, fornecedor.getEmpresa());
			statement.setString(2, fornecedor.getNome());
			statement.setString(3, fornecedor.getTelefone());
			statement.setString(4, fornecedor.getEmail());
			statement.setString(5, fornecedor.getCnpj());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Fornecedor fornecedor) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.UPDATE_ALL);
			
			statement.setString(1, fornecedor.getEmpresa());
			statement.setString(2, fornecedor.getNome());
			statement.setString(3, fornecedor.getTelefone());
			statement.setString(4, fornecedor.getEmail());
			statement.setString(5, fornecedor.getCnpj());
			statement.setInt(6, fornecedor.getId());
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean validar_email(String email) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_EMAIL);
			
			statement.setString(1, email);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				conexao.close();
				statement.close();
				result.close();
				return false;
			}
			conexao.close();
			statement.close();
			result.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean validar_cnpj(String cnpj) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_CNPJ);
			
			statement.setString(1, cnpj);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				conexao.close();
				statement.close();
				result.close();
				return false;
			}
			conexao.close();
			statement.close();
			result.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Fornecedor> getList() {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_ALL);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				Fornecedor fornecedor = new Fornecedor(result.getInt("id"), result.getString("empresa"), 
						result.getString("nome"), result.getString("telefone"), result.getString("email"), 
						result.getString("cnpj"));
				fornecedores.add(fornecedor);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fornecedores;
	}

}
