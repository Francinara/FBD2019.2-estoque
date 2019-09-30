package br.com.fbd.acad.entidade;

public class Produto {
	
	private Integer id;
	private int codigo;
	private String descricao;
	private double valorCompra;
	private double valorVenda;
	private int estoqueAtual;
	private String unidadeDeMedida;
	private Fornecedor fornecedor;
	private int ncm;
	private double tributaçao;
	
	public Produto(Integer id, int codigo, String descricao, double valorCompra, double valorVenda, int estoqueAtual,
			String unidadeDeMedida, Fornecedor fornecedor, int ncm, double tributaçao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.estoqueAtual = estoqueAtual;
		this.unidadeDeMedida = unidadeDeMedida;
		this.fornecedor = fornecedor;
		this.ncm = ncm;
		this.tributaçao = tributaçao;
	}

	public Produto(Integer id, int codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public int getNcm() {
		return ncm;
	}

	public void setNcm(int ncm) {
		this.ncm = ncm;
	}

	public double getTributaçao() {
		return tributaçao;
	}

	public void setTributaçao(double tributaçao) {
		this.tributaçao = tributaçao;
	}

}
