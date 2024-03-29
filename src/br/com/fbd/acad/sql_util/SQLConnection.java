package br.com.fbd.acad.sql_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
	
public static final String NOME_BD_CONNECTION_POSTGRESS = "POSTGRES";
	
	private static Connection conexao = null;
	
	private SQLConnection(){
		
	}
	
	public static Connection getConnectionInstance(){
		try {
			if(conexao == null || conexao.isClosed()){
				conexao = DriverManager.getConnection(SQLUtil.URL_POSTGRES, SQLUtil.USUARIO_POSTGRES, SQLUtil.SENHA_POSTGRES);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
	}
	

}
