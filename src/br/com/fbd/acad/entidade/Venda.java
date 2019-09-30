package br.com.fbd.acad.entidade;

import java.util.List;

public class Venda {
	
	private Integer id;
	private double valor;
	private List<Produto> produtos;
	private Cliente clientes;
	private Funcionario funcionario;
	
	public Venda(Integer id, double valor, List<Produto> produtos, Cliente clientes, Funcionario funcionario) {
		super();
		this.id = id;
		this.valor = valor;
		this.produtos = produtos;
		this.clientes = clientes;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
