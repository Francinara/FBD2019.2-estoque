package br.com.fbd.acad.entidade;

public class Empresa {
	
	private Integer id;
	private String nome;
	
	public Empresa(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Empresa(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
