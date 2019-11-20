package br.com.fbd.acad.dao;

import java.util.List;

import br.com.fbd.acad.entidade.Funcionario;

public interface IDaoFuncionario {
	
	public boolean cadastrar(Funcionario funcionario);
	public boolean editar(Funcionario funcionario);
	public boolean excluir(int id);
	public boolean validarLogin(String email, String senha);
	public boolean validarEmail(String email);
	public boolean validarCpf(String cpf);
	public Funcionario selecionarFuncionario(String email);
	public boolean isEmpty();
	public List<Funcionario> getList();

}
