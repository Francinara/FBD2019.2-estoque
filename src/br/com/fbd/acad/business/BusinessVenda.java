package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoVenda;
import br.com.fbd.acad.dao.IDaoVenda;
import br.com.fbd.acad.entidade.Venda;

public class BusinessVenda implements IBusinessVenda{
	
	private IDaoVenda daoVenda;
	
	public BusinessVenda() {
		daoVenda = new DaoVenda();
	}

	@Override
	public boolean cadastrar(Venda venda) {
		if(daoVenda.cadastrar(venda)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Venda> getList() {
		return daoVenda.getList();
	}
	

}
