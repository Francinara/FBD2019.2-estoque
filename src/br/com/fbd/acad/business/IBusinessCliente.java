package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Cliente;

public interface IBusinessCliente {
	
	public String cadastrar(Cliente cliente);
	public String editar(Cliente cliente);
	public boolean excluir(int id);
	public List<Cliente> getList();

}
