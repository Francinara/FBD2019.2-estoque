package br.com.fbd.acad.business;

import br.com.fbd.acad.entidade.Categoria;

public interface IBusinessCategoria {
	
	public boolean cadastrar(Categoria categoria);
	public boolean editar(Categoria categoria);

}
