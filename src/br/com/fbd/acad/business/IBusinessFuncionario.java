package br.com.fbd.acad.business;

import br.com.fbd.acad.entidade.Funcionario;

public interface IBusinessFuncionario {
	
	public boolean cadastrar(Funcionario funcionario);
	public boolean validarLogin(String email, String senha);
	public boolean verificarAcesso(int cargo);
	
}
