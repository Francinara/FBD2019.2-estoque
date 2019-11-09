package br.com.fbd.acad.entidade;

public class ProdutoVenda {
	
	private Integer id;
	private Integer id_produto;
	private Integer id_venda;
	private int quantidade;
	
	public ProdutoVenda(Integer id, Integer id_produto, Integer id_venda, int quantidade) {
		super();
		this.id = id;
		this.id_produto = id_produto;
		this.id_venda = id_venda;
		this.quantidade = quantidade;
	}

	public ProdutoVenda(Integer id_produto, Integer id_venda, int quantidade) {
		super();
		this.id_produto = id_produto;
		this.id_venda = id_venda;
		this.quantidade = quantidade;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
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
