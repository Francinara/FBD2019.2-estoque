package br.com.fbd.acad.business;

import br.com.fbd.acad.dao.DaoCargo;
import br.com.fbd.acad.dao.IDaoCargo;
import br.com.fbd.acad.entidade.Cargo;

public class BusinessCargo implements IBusinessCargo {
	
	private static IDaoCargo daoCargo;
	
	public BusinessCargo() {
		daoCargo = new DaoCargo();
	}

	@Override
	public boolean cadastrar(Cargo cargo) {
		if(daoCargo.validar_nome(cargo.getCargo())) {
			if(daoCargo.cadastrar(cargo)) {
				return true;
			}
		}return false;
	}
	public boolean editar(Cargo cargo) {
		if(daoCargo.validar_nome(cargo.getCargo())) {
			if(daoCargo.editar(cargo)) {
				return true;
			}
		}return false;
	}

}
