package br.com.fbd.acad.sql_util;

public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/dados";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "123";
	
	public static class Cargo{
		private static String NOME_TABELA = "cargo";
		private static String COL_NOME = "nome";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME +") values (?)";
	}

}
