package br.com.fbd.acad.business;

import br.com.fbd.acad.entidade.Empresa;

public interface IBusinessEmpresa {

	public boolean cadastrar(Empresa empresa);
	public boolean editar(Empresa empresa);
	
}
