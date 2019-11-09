package br.com.fbd.acad.entidade;

public class Fornecedor{
	
	private Integer id;
	private String empresa;
	private String nome;
	private String telefone;
	private String email;
	private String cnpj;
	
	public Fornecedor(Integer id, String empresa, String nome, String telefone, String email, String cnpj) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
	}

	public Fornecedor(String empresa, String nome, String telefone, String email, String cnpj) {
		super();
		this.empresa = empresa;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}
	
}
