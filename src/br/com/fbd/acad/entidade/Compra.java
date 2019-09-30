package br.com.fbd.acad.entidade;

import java.sql.Date;
import java.util.List;

public class Compra {
	
	private Integer id;
	private List<Produto> produtos;
	private Date dataCompra;
	private double valorCompra;
	private Fornecedor fornecedor;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getDataCompra() {
		return dataCompra;
	}
	
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	public double getValorCompra() {
		return valorCompra;
	}
	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
