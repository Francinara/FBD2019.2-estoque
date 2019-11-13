package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Fornecedor;;

public interface IDaoFornecedor {
	
	public boolean cadastrar(Fornecedor fornecedor);
	public boolean editar(Fornecedor fornecedor);
	public boolean validar_email(String email);
	public boolean validar_cnpj(String cnpj);
	public List<Fornecedor> getList();

}
