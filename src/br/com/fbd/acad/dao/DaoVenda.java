package br.com.fbd.acad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fbd.acad.entidade.Venda;
import br.com.fbd.acad.sql_util.SQLConnection;
import br.com.fbd.acad.sql_util.SQLUtil;

public class DaoVenda implements IDaoVenda {
	
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	Calendar calendar = Calendar.getInstance();

	@Override
	public boolean cadastrar(Venda venda) {
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Venda.INSERT_ALL);

			statement.setDouble(1, venda.getValor());
			statement.setDate(2, venda.getData_venda(), calendar);
			statement.setInt(3, venda.getId_funcionario());
			statement.setInt(4, venda.getId_cliente());
			

			statement.execute();

			conexao.close();
			statement.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Venda> getList() {
		List<Venda> vendas = new ArrayList<Venda>();
		
		try {
			conexao = SQLConnection.getConnectionInstance();
			statement = conexao.prepareStatement(SQLUtil.Venda.SELECT_INNER);
			
			result = statement.executeQuery();
			
			while(result.next()) {
				Venda venda = new Venda(result.getInt("id"), result.getDouble("valor"), result.getDate("data_venda"), 
						result.getInt("id_funcionario"), result.getString("nome"), result.getInt("id_cliente"), result.getString("cliente"));
				vendas.add(venda);
			}
			statement.close();
			conexao.close();
			result.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendas;
	}

}
