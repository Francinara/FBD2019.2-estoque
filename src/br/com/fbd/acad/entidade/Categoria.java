package br.com.fbd.acad.entidade;

public class Categoria {
	
	private Integer id;
	private String categoria;
	
	public Categoria(Integer id, String categoria) {
		super();
		this.id = id;
		this.categoria = categoria;
	}
	
	public Categoria(String categoria) {
		super();
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return getCategoria();
	}

}
