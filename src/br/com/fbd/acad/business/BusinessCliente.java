package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoCliente;
import br.com.fbd.acad.dao.IDaoCliente;
import br.com.fbd.acad.entidade.Cliente;

public class BusinessCliente implements IBusinessCliente{

	private IDaoCliente daoCliente;

	public BusinessCliente() {
		daoCliente = new DaoCliente();
	}

	@Override
	public String cadastrar(Cliente cliente) {
		if(daoCliente.validarEmail(cliente.getEmail())) {
			if(daoCliente.cadastrar(cliente)) {
				return "0";
			}
		}return "Email já exite";
	}

	@Override
	public String editar(Cliente cliente) {
		return null;
	}
	@Override
	public boolean excluir(int id) {
		if(daoCliente.excluir(id)) {
			return true;
		}return false;
	}
	@Override
	public List<Cliente> getList() {
		return daoCliente.getList();
	}


}
