package br.com.fbd.acad.entidade;

public class Produto {
	
	private Integer id;
	private String descricao;
	private String codigo;
	private Integer id_categoria;
	private double preco;
	private double custo;
	private Integer id_fornecedor;
	private int quantidade;
	
	public Produto(Integer id, String descricao, String codigo, Integer id_categoria, double preco, double custo,
			Integer id_fornecedor, int quantidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		this.id_categoria = id_categoria;
		this.preco = preco;
		this.custo = custo;
		this.id_fornecedor = id_fornecedor;
		this.quantidade = quantidade;
	}

	public Produto(String descricao, String codigo, Integer id_categoria, double preco, double custo,
			Integer id_fornecedor, int quantidade) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.id_categoria = id_categoria;
		this.preco = preco;
		this.custo = custo;
		this.id_fornecedor = id_fornecedor;
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public Integer getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getId() {
		return id;
	}

}
