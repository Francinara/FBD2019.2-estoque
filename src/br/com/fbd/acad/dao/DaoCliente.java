package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fbd.acad.entidade.Cliente;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoCliente implements IDaoCliente {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public boolean cadastrar(Cliente cliente) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.INSERT_ALL);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getTelefone());

			statement.execute();

			conexao.close();
			statement.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Cliente cliente) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.UPDATE_ALL);

			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getEmail());
			statement.setString(3, cliente.getTelefone());
			statement.setInt(4, cliente.getId());

			statement.execute();

			conexao.close();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean excluir(int id) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.UPDATE_ATIVO);
			
			statement.setInt(1, id);
			
			statement.execute();
			
			conexao.close();
			statement.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean validarEmail(String email) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_EMAIL);

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
	public boolean isEmpty() {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_ALL);

			result = statement.executeQuery();

			if(result.next()) {
				conexao.close();
				statement.close();
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
	public List<Cliente> getList() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Cliente.SELECT_ALL);

			result = statement.executeQuery();

			while(result.next()) {
				if (result.getBoolean("ativo")){
					Cliente cliente = new Cliente(result.getInt("id"), result.getString("nome"), result.getString("email"), 
							result.getString("telefone"), result.getBoolean("ativo"));
					clientes.add(cliente);
				}	
			}

			conexao.close();
			statement.close();
			result.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}


}
