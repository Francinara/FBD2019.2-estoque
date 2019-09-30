package br.com.fbd.acad.sql_util;

public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/Dados";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "123";
	
	public static class Aluno{
		private static String NOME_TABELA = "aluno";
		private static String COL_NOME = "nome";
		private static String COL_CPF = "cpf";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME + "," +COL_CPF+ ") values (?,?)";
	}

}
