package br.com.fbd.acad.business;

import java.util.List;

import br.com.fbd.acad.entidade.Funcionario;

public interface IBusinessFuncionario {
	
	public String cadastrar(Funcionario funcionario);
	public String editar(Funcionario funcionario);
	public boolean excluir(int id);
	public boolean validarLogin(String email, String senha);
	public boolean verificarAcesso(int cargo);
	public List<Funcionario> getList();
	
	
}
