package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Categoria;

public interface IDaoCategoria{
	
	public boolean cadastrar(Categoria categoria);
	public boolean editar(Categoria categoria);
	public boolean validar_nome(String nome);
	public List<Categoria> getList();

}
