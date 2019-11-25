package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoVenda;
import br.com.fbd.acad.dao.IDaoVenda;
import br.com.fbd.acad.entidade.Produto;
import br.com.fbd.acad.entidade.Venda;

public class BusinessVenda implements IBusinessVenda{
	
	private IDaoVenda daoVenda;
	
	public BusinessVenda() {
		daoVenda = new DaoVenda();
	}
	
	@Override
	public boolean cadastrar(Venda venda, List<Produto> produtos) {
		if(daoVenda.cadastrar(venda, produtos)) {
			return true;
		}
		return false;
	}
	
	public int maxId() {
		return daoVenda.maxId();
	}

	@Override
	public List<Venda> getList() {
		return daoVenda.getList();
	}

	

}
