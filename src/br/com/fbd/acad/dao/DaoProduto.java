package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fbd.acad.entidade.Produto;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoProduto implements IDaoProduto {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public boolean cadastrar(Produto produto) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Produto.INSERT_ALL);


			statement.setString(1, produto.getDescricao());
			statement.setString(2, produto.getCodigo());
			statement.setInt(3, produto.getId_categoria());
			statement.setDouble(4, produto.getPreco());
			statement.setDouble(5, produto.getCusto());
			statement.setInt(6, produto.getId_fornecedor());
			statement.setInt(7, produto.getQuantidade());

			statement.execute();

			conexao.close();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean editar(Produto produto) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Produto.UPDATE_ALL);


			statement.setString(1, produto.getDescricao());
			statement.setString(2, produto.getCodigo());
			statement.setInt(3, produto.getId_categoria());
			statement.setDouble(4, produto.getPreco());
			statement.setDouble(5, produto.getCusto());
			statement.setInt(6, produto.getId_fornecedor());
			statement.setInt(7, produto.getQuantidade());
			statement.setInt(8, produto.getId());

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
			statement = conexao.prepareStatement(SQLUtil.Produto.UPDATE_ATIVO);

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
	public boolean validarCodigo(String codigo) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_CODIGO);


			statement.setString(1, codigo);

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
			statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_ALL);

			result = statement.executeQuery();

			if(result.next()) {
				conexao.close();
				statement.close();
				result.close();
				return false;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Produto> getList() {
		List<Produto> produtos = new ArrayList<Produto>();
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Produto.SELECT_INNER);

			result = statement.executeQuery();

			while(result.next()) {
				if(result.getBoolean("ativo")) {
					Produto produto = new Produto(result.getInt("id"), result.getString("descricao"), result.getString("codigo"), 
							result.getInt("id_categoria"), result.getString("categoria"), result.getDouble("preco"), 
							result.getDouble("custo"), result.getInt("id_fornecedor"), result.getString("empresa"), 
							result.getInt("quantidade"), result.getBoolean("ativo"));
					produtos.add(produto);
				}
			}

			conexao.close();
			statement.close();
			result.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return produtos;
	}

}
