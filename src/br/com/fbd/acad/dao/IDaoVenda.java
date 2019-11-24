package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Venda;


public interface IDaoVenda {
	
	public boolean cadastrar(Venda venda);
	public List<Venda> getList();	

}
