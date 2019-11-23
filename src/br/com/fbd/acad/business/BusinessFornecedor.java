package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoFornecedor;
import br.com.fbd.acad.dao.IDaoFornecedor;
import br.com.fbd.acad.entidade.Fornecedor;

public class BusinessFornecedor implements IBusinessFornecedor{

	private IDaoFornecedor daoFornecedor;

	public BusinessFornecedor() {
		daoFornecedor = new DaoFornecedor();
	}

	@Override
	public String cadastrar(Fornecedor fornecedor) {
		if(daoFornecedor.validarEmail(fornecedor.getEmail())) {
			if(daoFornecedor.validarCnpj(fornecedor.getCnpj())) {
				if(daoFornecedor.cadastrar(fornecedor)) {
					return "0";
				}
			}return "CNPJ já existe";
		}return "Email já exite";
	}

	@Override
	public String editar(Fornecedor fornecedor) {
		return null;
	}

	@Override
	public boolean excluir(int id) {
		if(daoFornecedor.excluir(id)) {
			return true;
		}return false;
	}

	@Override
	public List<Fornecedor> getList() {
		return daoFornecedor.getList();
	}

}
