package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConexionBD;

public class VueloDAO {

	public VueloDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Función que recibe un idVuelo y devuelve true si lo ha eliminado
	 * 
	 * @param idVuelo vuelo a eliminar
	 * @return true si ha podido eliminar el vuelo
	 */
	public boolean eliminarVuelo(int idVuelo) {
		boolean eliminadoCorrectamente = false;

		// Variables
		String query = "";
		Statement stmt;
		int regModificados =-1;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			stmt = con.createStatement();

			query = "DELETE FROM vuelos WHERE idvuelo = " + idVuelo;

			regModificados = stmt.executeUpdate(query);

			//Si hay un registro Modificado, se ha borrado correctamente
			if (regModificados==1) eliminadoCorrectamente = true;
			
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Cerramos las conexiones activas
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eliminadoCorrectamente;
	}

	

}
