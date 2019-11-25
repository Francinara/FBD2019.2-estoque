package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Venda {
	
	private Integer id;
	private double valor;
	private Date data_venda;
	private Integer id_funcionario;
	private String funcionario;
	private Integer id_cliente;
	private String cliente;
	
	public Venda(Integer id, double valor, Date data_venda, Integer id_funcionario, String funcionario, Integer id_cliente, 
			String cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_venda = data_venda;
		this.id_funcionario = id_funcionario;
		this.funcionario = funcionario;
		this.id_cliente = id_cliente;
		this.cliente = cliente;
	}

	public Venda(Integer id, double valor, Date data_venda, Integer id_funcionario, Integer id_cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_venda = data_venda;
		this.id_funcionario = id_funcionario;
		this.id_cliente = id_cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId() {
		return id;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
