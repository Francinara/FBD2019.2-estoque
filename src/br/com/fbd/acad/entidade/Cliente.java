package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Cliente extends Usuario {

	public Cliente(Integer id, String nome, String cpf, String re, Date dataNascimento, Contato contato,
			Endereco endereco) {
		super(id, nome, cpf, re, dataNascimento, contato, endereco);
	}
	
	
	
}
