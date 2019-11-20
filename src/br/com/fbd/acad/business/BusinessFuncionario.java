package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.IDaoFuncionario;
import br.com.fbd.acad.entidade.Funcionario;

public class BusinessFuncionario implements IBusinessFuncionario{

	private IDaoFuncionario daoFuncionario;

	public BusinessFuncionario() {
		daoFuncionario = new DaoFuncionario();
	}

	@Override
	public String cadastrar(Funcionario funcionario) {
		if(daoFuncionario.validarEmail(funcionario.getEmail())) {
			if(daoFuncionario.validarCpf(funcionario.getCpf())) {
				if(daoFuncionario.cadastrar(funcionario)) {
					return "0";
				}
			}return "CPF já cadastrado";
		}return "Email já exite";
	}

	public String editar(Funcionario funcionario) {
		return null;
	}

	public boolean excluir(int id) {
		if(daoFuncionario.excluir(id)) {
			return true;
		}return false;
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

	@Override
	public List<Funcionario> getList() {
		return daoFuncionario.getList();
	}




}
