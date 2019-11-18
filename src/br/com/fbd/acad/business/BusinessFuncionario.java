package br.com.fbd.acad.business;

import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.IDaoFuncionario;
import br.com.fbd.acad.entidade.Funcionario;

public class BusinessFuncionario implements IBusinessFuncionario{

	private IDaoFuncionario daoFuncionario;
	
	public BusinessFuncionario() {
		daoFuncionario = new DaoFuncionario();
	}
	
	@Override
	public boolean cadastrar(Funcionario funcionario) {
		if(daoFuncionario.cadastrar(funcionario)) {
			return true;
		}else return false;
	}
	
	@Override
	public boolean validarLogin(String email, String senha) {
		if(daoFuncionario.validarLogin(email, senha)) {
			return true;
		}
		return false;
	}
	
	public boolean verificarAcesso(int cargo) {
		if(cargo == 1 || cargo == 0){
			return true;
		}return false;
	}

	

}
