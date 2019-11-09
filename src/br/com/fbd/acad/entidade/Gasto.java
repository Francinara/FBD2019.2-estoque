package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Gasto{
	
	private Integer id;
	private boolean valor;
	private Date data_gasto;
	private Integer id_funcionario;
	private Integer id_fornecedor;
	
	public Gasto(Integer id, boolean valor, Date data_gasto, Integer id_funcionario, Integer id_fornecedor) {
		super();
		this.id = id;
		this.valor = valor;
		this.data_gasto = data_gasto;
		this.id_funcionario = id_funcionario;
		this.id_fornecedor = id_fornecedor;
	}

	public Gasto(boolean valor, Date data_gasto, Integer id_funcionario, Integer id_fornecedor) {
		super();
		this.valor = valor;
		this.data_gasto = data_gasto;
		this.id_funcionario = id_funcionario;
		this.id_fornecedor = id_fornecedor;
	}

	public boolean isValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	public Date getData_gasto() {
		return data_gasto;
	}

	public void setData_gasto(Date data_gasto) {
		this.data_gasto = data_gasto;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Integer getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public Integer getId() {
		return id;
	}

}
