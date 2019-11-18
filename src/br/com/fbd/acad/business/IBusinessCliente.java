package br.com.fbd.acad.business;

import br.com.fbd.acad.entidade.Cliente;

public interface IBusinessCliente {
	
	public boolean cadastrar(Cliente cliente);
	public boolean editar(Cliente cliente);

}
