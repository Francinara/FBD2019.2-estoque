package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Funcionario extends Usuario {
	
	private Funcao funcao;
	
	
	public Funcionario(Integer id, String nome, String cpf, String re, Date dataNascimento, Contato contato,
			Endereco endereco, Funcao funcao) {
		super(id, nome, cpf, re, dataNascimento, contato, endereco);
		this.funcao = funcao;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

}
