package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fbd.acad.entidade.Funcionario;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario {
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	Calendar calendar = Calendar.getInstance();
	
	private Funcionario funcionario;
	
	public boolean cadastrar(Funcionario funcionario) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.INSERT_ALL);
			
			
			statement.setInt(1, funcionario.getId_cargo());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getEmail());
			statement.setString(4, funcionario.getTelefone());
			statement.setDate(5, funcionario.getNascimento(), calendar);
			statement.setString(6, funcionario.getCpf());
			statement.setString(7, funcionario.getSenha());
	
			statement.execute();
			
			conexao.close();
			statement.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean editar(Funcionario funcionario) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.UPDATE_ALL);
			
			
			statement.setInt(1, funcionario.getId_cargo());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getEmail());
			statement.setString(4, funcionario.getTelefone());
			statement.setDate(5, funcionario.getNascimento(), calendar);
			statement.setString(6, funcionario.getCpf());
			statement.setString(7, funcionario.getSenha());
			statement.setInt(8, funcionario.getId());
	
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
			statement = conexao.prepareStatement(SQLUtil.Funcionario.UPDATE_ATIVO);
			
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
	public boolean validarLogin(String email, String senha) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_LOGIN);
			
			statement.setString(1, email);
			statement.setString(2, senha);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				statement.close();
				conexao.close();
				result.close();
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean isEmpty() {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ALL);
			
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
	public List<Funcionario> getList() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_ALL);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				if(result.getBoolean("ativo")) {
				Funcionario funcionario = new Funcionario(result.getInt("id"), result.getInt("id_cargo"), 
						result.getString("nome"), result.getString("email"), result.getString("telefone"), 
						result.getDate("data_nascimento"), result.getString("cpf"), result.getString("senha"), 
						result.getBoolean("ativo"));
				funcionarios.add(funcionario);
				}
			}
			statement.close();
			conexao.close();
			result.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	@Override
	public boolean validarEmail(String email) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_EMAIL);
			
			statement.setString(1, email);
			
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
	public boolean validarCpf(String cpf) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_CPF);
			
			statement.setString(1, cpf);
			
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
	public Funcionario selecionarFuncionario(String email) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Funcionario.SELECT_EMAIL);
			
			statement.setString(1, email);
			
			result = statement.executeQuery();
			
			if(result.next()) {
				this.funcionario = new Funcionario(result.getInt("id"), result.getInt("id_cargo"), 
						result.getString("nome"), result.getString("email"), result.getString("telefone"), 
						result.getDate("data_nascimento"), result.getString("cpf"), result.getString("senha"), 
						result.getBoolean("ativo"));
			}
			statement.close();
			conexao.close();
			result.close();
			
			return funcionario;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionario;
	}

}
