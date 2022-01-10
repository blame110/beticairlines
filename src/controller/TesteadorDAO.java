package controller;

import java.util.ArrayList;

import model.pasajeroDAO;
import model.pasajeroVO;

public class TesteadorDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pasajeroDAO pasajero = new pasajeroDAO();
		pasajeroVO juan = new pasajeroVO(1,"",22,"",false);
		ArrayList<pasajeroVO> pasajeros = new ArrayList<pasajeroVO>();

		juan = pasajero.cargarPasajero(1);
		
		System.out.println(juan);
		
		juan.setEdad(98);
		
		pasajero.modificarPasajero(juan, false);
		
		System.out.println(juan);
		
		pasajero.eliminarPasajero(7);

		juan.setNombre("Juldfian");
		juan.setDni("66777888i");
		juan.setEdad(50);
		juan.setBusiness(true);
		
		pasajero.guardarPasajero(juan);
		
		
	}

}
