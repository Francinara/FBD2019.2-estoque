package br.com.fbd.acad.app;

import br.com.fbd.acad.business.BusinessCargo;
import br.com.fbd.acad.business.IBusinessCargo;
import br.com.fbd.acad.entidade.Cargo;

public class App {
	public static void main(String[] args) {
		IBusinessCargo businessCargo = new BusinessCargo();
		Cargo cargo = new Cargo("Administrador");
		businessCargo.cadastrar(cargo);
	}

}
