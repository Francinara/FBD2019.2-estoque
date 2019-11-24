package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Categoria;

public interface IBusinessCategoria {
	
	public boolean cadastrar(Categoria categoria);
	public boolean editar(Categoria categoria);
	public List<Categoria> getList();

}
