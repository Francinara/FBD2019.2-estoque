package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Produto;
import br.com.fbd.acad.entidade.Venda;

public interface IBusinessVenda {
	
	public boolean cadastrar(Venda venda, List<Produto> produtos);
	public List<Venda> getList();
	public int maxId();

}
