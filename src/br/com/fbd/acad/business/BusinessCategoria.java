package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoCategoria;
import br.com.fbd.acad.dao.IDaoCategoria;
import br.com.fbd.acad.entidade.Categoria;

public class BusinessCategoria implements IBusinessCategoria{
	
	private IDaoCategoria daoCategoria;
	
	public BusinessCategoria() {
		daoCategoria = new DaoCategoria();
	}

	@Override
	public boolean cadastrar(Categoria categoria) {
		if(daoCategoria.validar_nome(categoria.getCategoria())) {
			if(daoCategoria.cadastrar(categoria)) {
				return true;
			}
		}return false;
	}

	@Override
	public boolean editar(Categoria categoria) {
		if(daoCategoria.validar_nome(categoria.getCategoria())) {
			if(daoCategoria.editar(categoria)) {
				return true;
			}
		}return false;
	}
	
	public List<Categoria> getList(){
		return daoCategoria.getList();
	}

}
