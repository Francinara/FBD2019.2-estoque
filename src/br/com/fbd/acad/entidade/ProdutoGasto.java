package br.com.fbd.acad.entidade;

public class ProdutoGasto {
	
	private Integer id;
	private Integer id_produto;
	private Integer id_gasto;
	private int quantidade;
	
	public ProdutoGasto(Integer id, Integer id_produto, Integer id_gasto, int quantidade) {
		super();
		this.id = id;
		this.id_produto = id_produto;
		this.id_gasto = id_gasto;
		this.quantidade = quantidade;
	}

	public ProdutoGasto(Integer id_produto, Integer id_gasto, int quantidade) {
		super();
		this.id_produto = id_produto;
		this.id_gasto = id_gasto;
		this.quantidade = quantidade;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public Integer getId_gasto() {
		return id_gasto;
	}

	public void setId_gasto(Integer id_gasto) {
		this.id_gasto = id_gasto;
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
