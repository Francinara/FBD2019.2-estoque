package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Cliente;

public interface IDaoCliente {

	public boolean cadastrar(Cliente cliente);
	public boolean editar(Cliente cliente);
	public boolean validarEmail(String email);
	public boolean isEmpty();
	public List<Cliente> getList();	
	
}
