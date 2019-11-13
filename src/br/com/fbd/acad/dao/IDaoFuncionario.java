package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Funcionario;

public interface IDaoFuncionario {
	
	public boolean cadastrar(Funcionario funcionario);
	public boolean editar(Funcionario funcionario);
	public boolean validarLogin(String email, String senha);
	public boolean validarEmail(String email);
	public boolean validarCpf(String cpf);
	public boolean isEmpty();
	public List<Funcionario> getList();

}
