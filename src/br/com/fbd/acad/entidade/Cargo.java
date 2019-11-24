package br.com.fbd.acad.entidade;

public class Cargo {
	
	private Integer id;
	private String cargo;
	
	public Cargo(Integer id, String cargo) {
		super();
		this.id = id;
		this.cargo = cargo;
	}
	
	public Cargo(String cargo) {
		super();
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return getCargo();
	}
	
}
