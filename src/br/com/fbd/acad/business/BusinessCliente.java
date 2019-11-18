package br.com.fbd.acad.business;

import br.com.fbd.acad.dao.DaoCliente;
import br.com.fbd.acad.dao.IDaoCliente;
import br.com.fbd.acad.entidade.Cliente;

public class BusinessCliente implements IBusinessCliente{
	
	private IDaoCliente daoCliente;
	
	public BusinessCliente() {
		daoCliente = new DaoCliente();
	}

	@Override
	public boolean cadastrar(Cliente cliente) {
		if(daoCliente.cadastrar(cliente)) {
			return true;
		}return false;
	}
	
	public boolean validarEmail(String email) {
		if(daoCliente.validarEmail(email)) {
			return true;
		}return false;
	}

	@Override
	public boolean editar(Cliente cliente) {
		if(daoCliente.editar(cliente)) {
			return true;
		}return false;
	}
	

}
