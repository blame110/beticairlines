package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class pasajeroDAO {

	public pasajeroVO cargarPasajero(int idPasajero)

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		pasajeroVO pasajero = null;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			stmt = con.createStatement();

			query = "SELECT * FROM PASAJEROS WHERE idpasajeros = " + idPasajero;

			res = stmt.executeQuery(query);
			// Si el resulset no esta vacio creamos el pasajeroVO
			if (res.next()) {
				pasajero = new pasajeroVO(res.getInt("idpasajeros"), res.getString("nombre"), res.getInt("edad"),
						res.getString("dni"), res.getInt("bussiness") == 1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pasajero;
		}
		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasajero;
	}

	public ArrayList<pasajeroVO> cargarPasajero(String nombre)

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		pasajeroVO pasajero = null;
		// Arraylist para guardar los pasajeros con el nombre recibido
		ArrayList<pasajeroVO> pasajeros = new ArrayList<pasajeroVO>();

		// Concetamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			stmt = con.createStatement();

			// Creamos la consulta
			query = "SELECT * FROM PASAJEROS WHERE nombre like  '%" + nombre + "%'";

			// Ejecutamos la query
			res = stmt.executeQuery(query);

			// Si el resulset no esta vacio creamos el pasajeroVO
			while (res.next()) {

				// Creamos un pasajeroVO con los datos de la query
				pasajero = new pasajeroVO(res.getInt("idpasajeros"), res.getString("nombre"), res.getInt("edad"),
						res.getString("dni"), res.getInt("bussiness") == 1);

				// Añado el pasajero al array
				pasajeros.add(pasajero);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pasajeros;
		}
		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pasajeros;
	}

	public ArrayList<pasajeroVO> cargarPasajeros()

	{
		// Variables
		ResultSet res;
		String query = "";
		Statement stmt;
		pasajeroVO pasajero = null;
		// Arraylist para guardar los pasajeros con el nombre recibido
		ArrayList<pasajeroVO> pasajeros = new ArrayList<pasajeroVO>();

		// Concetamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			stmt = con.createStatement();

			// Creamos la consulta
			query = "SELECT * FROM PASAJEROS";

			// Ejecutamos la query
			res = stmt.executeQuery(query);

			// Si el resulset no esta vacio creamos el pasajeroVO
			while (res.next()) {

				// Creamos un pasajeroVO con los datos de la query
				pasajero = new pasajeroVO(res.getInt("idpasajeros"), res.getString("nombre"), res.getInt("edad"),
						res.getString("dni"), res.getInt("bussiness") == 1);

				// Añado el pasajero al array
				pasajeros.add(pasajero);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// Cerramos las conexiones activas

			return pasajeros;
		}
		// Cerramos las conexiones activas
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pasajeros;
	}

}
