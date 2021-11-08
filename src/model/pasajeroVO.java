package model;

import java.io.Serializable;

public class pasajeroVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idPasajero;
	String nombre;
	int edad;
	String dni;
	boolean business;

	public pasajeroVO(int idPasajero, String nombre, int edad, String dni, boolean business) {
		super();
		this.idPasajero = idPasajero;
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
		this.business = business;
	}

	public int getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}

	@Override
	public String toString() {
		return "pasajeroVO [idPasajero=" + idPasajero + ", nombre=" + nombre + ", edad=" + edad + ", dni=" + dni
				+ ", business=" + business + "]";
	}

}
