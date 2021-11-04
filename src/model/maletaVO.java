package model;

public class maletaVO {

	int idMaletas;
	int dimensiones;
	int peso;
	String tipo;

	public maletaVO(int idMaletas, int dimensiones, int peso, String tipo) {
		super();
		this.idMaletas = idMaletas;
		this.dimensiones = dimensiones;
		this.peso = peso;
		this.tipo = tipo;
	}

	public int getIdMaletas() {
		return idMaletas;
	}

	public void setIdMaletas(int idMaletas) {
		this.idMaletas = idMaletas;
	}

	public int getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(int dimensiones) {
		this.dimensiones = dimensiones;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "maletaVO [idMaletas=" + idMaletas + ", dimensiones=" + dimensiones + ", peso=" + peso + ", tipo=" + tipo
				+ "]";
	}

}
