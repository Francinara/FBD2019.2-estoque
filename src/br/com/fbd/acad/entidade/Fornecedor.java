package br.com.fbd.acad.entidade;

public class Fornecedor extends Empresa{
	
	private String representante;

	public Fornecedor(Integer id, String razaoSocial, String cnpj, Endereco endereco, Contato contato,
			String representante) {
		super(id, razaoSocial, cnpj, endereco, contato);
		this.representante = representante;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	
}
