package br.com.fbd.acad.entidade;

import java.sql.Date;

public class Funcionario {
	
	private Integer id;
	private Integer id_cargo;
	private String nome;
	private String email;
	private String telefone;
	private Date nascimento;
	private String cpf;
	private String senha;
	private boolean ativo;
	
	public Funcionario(Integer id, Integer id_cargo, String nome, String email, String telefone, Date nascimento, String cpf,
			String senha, boolean ativo) {
		super();
		this.id = id;
		this.id_cargo = id_cargo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.senha = senha;
		this.ativo = ativo;
	}
	
	public Funcionario(Integer id_cargo, String nome, String email, String telefone, Date nascimento, String cpf, String senha) {
		super();
		this.id_cargo = id_cargo;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Integer getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return getNome();
	}

}
