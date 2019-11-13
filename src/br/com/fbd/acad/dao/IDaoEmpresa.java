package br.com.fbd.acad.dao;

import br.com.fbd.acad.entidade.Empresa;

public interface IDaoEmpresa {
	
	public boolean cadastrar(Empresa empresa );
	public boolean editar(Empresa empresa);

}
