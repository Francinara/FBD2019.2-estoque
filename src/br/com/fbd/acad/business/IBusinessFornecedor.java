package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Fornecedor;

public interface IBusinessFornecedor {
	
	public String cadastrar(Fornecedor fornecedor);
	public String editar(Fornecedor fornecedor);
	public boolean excluir(int id);
	public List<Fornecedor> getList();

}
