package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Venda {
	
	private Integer id;
	private boolean valor;
	private Date data_venda;
	private Integer id_funcionario;
	private Integer id_cliente;
	
	public Venda(Integer id, boolean valor, Date data_venda, Integer id_funcionario, Integer id_cliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_venda = data_venda;
		this.id_funcionario = id_funcionario;
		this.id_cliente = id_cliente;
	}

	public Venda(boolean valor, Date data_venda, Integer id_funcionario, Integer id_cliente) {
		super();
		this.valor = valor;
		this.data_venda = data_venda;
		this.id_funcionario = id_funcionario;
		this.id_cliente = id_cliente;
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
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

}
