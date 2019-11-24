package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Venda;

public interface IBusinessVenda {
	
	public boolean cadastrar(Venda venda);
	public List<Venda> getList();

}
