package br.com.fbd.acad.sql_util;

public class SQLUtil {

	public static String URL_POSTGRES = "jdbc:postgresql://localhost:5432/dados";
	public static String USUARIO_POSTGRES = "postgres";
	public static String SENHA_POSTGRES = "123";
	
	public static class Cargo{
		private static String NOME_TABELA = "cargo";
		private static String COL_NOME = "cargo";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME +") values (?)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_NOME+"=? WHERE id=?";
		public static String SELECT_NOME = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_NOME+"=?";
	}
	
	public static class Categoria{
		private static String NOME_TABELA = "categoria";
		private static String COL_NOME = "categoria";

		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME +") values (?)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_NOME+"=? WHERE id=?";
		public static String SELECT_NOME = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_NOME+"=?";
		
	}
	
	public static class Cliente{
		private static String NOME_TABELA = "clientes";
		private static String COL_NOME = "cliente";
		private static String COL_EMAIL = "email";
		private static String COL_TELEFONE = "telefone";
		private static String COL_ATIVO = "ativo";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME +","+COL_EMAIL+","+COL_TELEFONE+","+COL_ATIVO+") values (?,?,?,true)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_NOME+"=?,"+COL_EMAIL+"=?,"+COL_TELEFONE+"=? WHERE id=?";
		public static String SELECT_EMAIL = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_EMAIL+"=?";
		public static String UPDATE_ATIVO = "UPDATE " +NOME_TABELA+" SET "+COL_ATIVO+"=false WHERE id=?";
		
	}
	
	public static class Empresa{
		private static String NOME_TABELA = "empresa";
		private static String COL_NOME = "nome";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_NOME +") values (?)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_NOME+"=? WHERE id=?";
		
	}
	
	public static class Fornecedor{
		private static String NOME_TABELA = "fornecedores";
		private static String COL_EMPRESA = "empresa";
		private static String COL_NOME = "nome";
		private static String COL_TELEFONE = "telefone";
		private static String COL_EMAIL = "email";
		private static String COL_CNPJ = "cnpj";
		private static String COL_ATIVO = "ativo";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_EMPRESA +","+COL_NOME+","+COL_TELEFONE+","+COL_EMAIL+","+COL_CNPJ+","+COL_ATIVO+") values (?,?,?,?,?,true)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_EMPRESA+"=?,"+COL_NOME+"=?,"+COL_TELEFONE+"=?,"+COL_EMAIL+"=?,"+COL_CNPJ+"=? WHERE id=?";
		public static String SELECT_EMAIL = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_EMAIL+"=?";
		public static String SELECT_CNPJ = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_CNPJ+"=?";
		public static String UPDATE_ATIVO = "UPDATE " +NOME_TABELA+" SET "+COL_ATIVO+"=false WHERE id=?";
		
	}
	
	public static class Funcionario{
		private static String NOME_TABELA = "funcionarios";
		private static String COL_CARGO = "id_cargo";
		private static String COL_NOME = "nome";
		private static String COL_EMAIL = "email";
		private static String COL_TELEFONE = "telefone";
		private static String COL_DATA = "data_nascimento";
		private static String COL_CPF = "cpf";
		private static String COL_SENHA = "senha";
		private static String COL_ATIVO = "ativo";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_CARGO +","+COL_NOME+","+COL_EMAIL+","+COL_TELEFONE+","+COL_DATA+","+COL_CPF+","+COL_SENHA+","+COL_ATIVO+") values (?,?,?,?,?,?,?,true)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_CARGO+"=?,"+COL_NOME+"=?,"+COL_EMAIL+"=?,"+COL_TELEFONE+"=?,"+COL_DATA+"=?,"+COL_CPF+"=?,"+COL_SENHA+"=? WHERE id=?";
		public static String SELECT_LOGIN = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_EMAIL+"=? AND "+COL_SENHA+"=?";
		public static String SELECT_EMAIL = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_EMAIL+"=?";
		public static String SELECT_CPF = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_CPF+"=?";
		public static String UPDATE_ATIVO = "UPDATE " +NOME_TABELA+" SET "+COL_ATIVO+"=false WHERE id=?";
		
		
	}
	
	public static class Produto{
		private static String NOME_TABELA = "produtos";
		private static String COL_DESCRICAO = "descricao";
		private static String COL_CODIGO = "codigo";
		private static String COL_CATEGORIA = "id_categoria";
		private static String COL_PRECO = "preco";
		private static String COL_CUSTO = "custo";
		private static String COL_FORNECEDOR = "id_fornecedor";
		private static String COL_QUANTIDADE = "quantidade";
		private static String COL_ATIVO = "ativo";
		
		private static String TABELA_CATEGORIA = "categoria";
		private static String CATEGORIA_ID = "categoria.id";
		private static String TABELA_FORNECEDORES = "fornecedores";
		private static String FORNECEDOR_ID = "fornecedores.id";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_DESCRICAO +","+COL_CODIGO+","+COL_CATEGORIA+","+COL_PRECO+","+COL_CUSTO+","+COL_FORNECEDOR+","+COL_QUANTIDADE+","+COL_ATIVO+") values (?,?,?,?,?,?,?,true)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_DESCRICAO+"=?,"+COL_CODIGO+"=?,"+COL_CATEGORIA+"=?,"+COL_PRECO+"=?,"+COL_CUSTO+"=?,"+COL_FORNECEDOR+"=?,"+COL_QUANTIDADE+"=? WHERE id=?";
		public static String SELECT_CODIGO = "SELECT * FROM "+NOME_TABELA+" WHERE "+COL_CODIGO+"=?";
		public static String UPDATE_ATIVO = "UPDATE " +NOME_TABELA+" SET "+COL_ATIVO+"=false WHERE id=?";
		public static String SELECT_INNER = "SELECT * FROM "+NOME_TABELA+" "
				+ "INNER JOIN "+TABELA_CATEGORIA+" ON "+COL_CATEGORIA+"="+CATEGORIA_ID
				+ " INNER JOIN "+ TABELA_FORNECEDORES+ " ON "+ COL_FORNECEDOR +"="+FORNECEDOR_ID;
		
	}

	public static class ProdutoVenda{
		private static String NOME_TABELA = "produto_venda";
		private static String COL_PRODUTO = "id_produto";
		private static String COL_VENDA = "id_gasto";
		private static String COL_QUANTIDADE = "quantidade";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_PRODUTO +","+COL_VENDA+","+COL_QUANTIDADE+") values (?,?,?)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_PRODUTO+"=?,"+COL_VENDA+"=?,"+COL_QUANTIDADE+"=? WHERE id=?";
		
	}
	public static class Venda{
		private static String NOME_TABELA = "venda";
		private static String COL_VALOR = "valor";
		private static String COL_DATA = "data_venda";
		private static String COL_FUNCIONARIO = "id_funcionario";
		private static String COL_CLIENTE = "id_cliente";
		
		private static String TABELA_FUNCIONARIO = "funcionarios";
		private static String FUNCIONARIO_ID = "funcionarios.id";
		private static String TABELA_CLIENTE = "clientes";
		private static String CLIENTE_ID = "clientes.id";
		
		public static String INSERT_ALL = "INSERT INTO "+ NOME_TABELA +" ("+ COL_VALOR +","+COL_DATA+","+COL_FUNCIONARIO+","+COL_CLIENTE+") values (?,?,?,?)";
		public static String SELECT_ALL = "SELECT * FROM "+NOME_TABELA;
		public static String UPDATE_ALL = "UPDATE "+NOME_TABELA+" SET "+COL_VALOR+"=?,"+COL_DATA+"=?,"+COL_FUNCIONARIO+"=?,"+COL_CLIENTE+"=? WHERE id=?";
		public static String SELECT_INNER = "SELECT * FROM "+NOME_TABELA+" "
				+ "INNER JOIN "+TABELA_FUNCIONARIO+" ON "+COL_FUNCIONARIO+"="+FUNCIONARIO_ID
				+ " INNER JOIN "+ TABELA_CLIENTE+ " ON "+ COL_CLIENTE +"="+CLIENTE_ID;
		
		
	}
}
