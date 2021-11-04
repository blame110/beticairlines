package controller;

import java.util.ArrayList;

import model.pasajeroDAO;
import model.pasajeroVO;

public class LanzadorPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pasajeroDAO pasajero = new pasajeroDAO();
		pasajeroVO juan;
		ArrayList<pasajeroVO> pasajeros = new ArrayList<pasajeroVO>();

		juan = pasajero.cargarPasajero(1);

		System.out.println(juan);

		pasajeros = pasajero.cargarPasajero("juan");

		System.out.println("\n\nLista de pasajeros:\n" + pasajeros);

		pasajeros = pasajero.cargarPasajeros();

		System.out.println("\n\nLista de pasajeros:\n" + pasajeros);

	}

}
