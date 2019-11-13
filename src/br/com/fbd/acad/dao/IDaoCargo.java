package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Cargo;

public interface IDaoCargo {
	
	public boolean cadastrar(Cargo cargo);
	public boolean editar(Cargo cargo);
	public boolean validar_nome(String nome);
	public List<Cargo> getList();

}
