package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Produto;

public interface IDaoProduto {
	
	public boolean cadastrar(Produto produto);
	public boolean editar(Produto produto);
	public boolean excluir(int id);
	public boolean validarCodigo(String codigo);
	public boolean isEmpty();
	public List<Produto> getList();
	public List<Produto> getListEstoque();

}
