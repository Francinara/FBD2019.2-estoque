package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoProduto;
import br.com.fbd.acad.dao.IDaoProduto;
import br.com.fbd.acad.entidade.Produto;

public class BusinessProduto implements IBusinessProduto{
	
	private IDaoProduto daoProduto;
	
	public BusinessProduto() {
		daoProduto = new DaoProduto();
	}

	@Override
	public String cadastrar(Produto produto) {
		if(daoProduto.validarCodigo(produto.getCodigo())) {
			if(daoProduto.cadastrar(produto)) {
				return "0";
			}
		}return "Código já exite";
	}

	@Override
	public String editar(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean excluir(int id) {
		if(daoProduto.excluir(id)) {
			return true;
		}return false;
	}

	@Override
	public List<Produto> getList() {
		return daoProduto.getList();
	}

	@Override
	public List<Produto> getListEstoque() {
		return daoProduto.getListEstoque();
	}

}
