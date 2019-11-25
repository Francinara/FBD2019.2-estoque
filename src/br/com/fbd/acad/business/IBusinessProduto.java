package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Produto;

public interface IBusinessProduto {
	
	public String cadastrar(Produto produto);
	public String editar(Produto produto);
	public boolean excluir(int id);
	public List<Produto> getList();
	public List<Produto> getListEstoque();

}
