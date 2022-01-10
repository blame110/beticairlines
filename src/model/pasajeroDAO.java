package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class pasajeroDAO {

	/**
	 * Función que inserta en BD un pasajero, no comprueba que los datos sean correctos
	 * deben de estar comprobados previamente a llamar a esta función. 
	 * @param pasajeroVO con los datos cargados
	 * @return -1 si ha habido fallo al insertar el registro
	 */
	public int guardarPasajero(pasajeroVO pasajero)
	{
		// Variables
		
		String query = "";
		//Por defecto ponemos el valor de fallo
		int resultado =-1;
		PreparedStatement pStmt;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			query = "INSERT INTO `pasajeros` (`nombre`, `edad`, `dni`, `bussiness`) VALUES (?,?,?,?)";
					
			//Añadimos el id pasajero al preparedStatement
			pStmt = con.prepareStatement(query);
			
			//Cargamos los datos a la query
			pStmt.setString(1, pasajero.getNombre());
			pStmt.setInt(2, pasajero.getEdad());
			pStmt.setString(3, pasajero.getDni());
			pStmt.setBoolean(4, pasajero.isBusiness());

			//Ejecutamos la query
			resultado = pStmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado=-1;
			return resultado;
		}
		// Cerramos las conexiones activas
		try {
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	
	/**
	 * Función que recibe un identificador de pasajero y lo elimina de la BD
	 * @param idPasajero
	 * @return -1 si ha habido fallo
	 */
	public static int eliminarPasajero(int idPasajero)
	{
		// Variables
		
		String query = "";
		//Por defecto ponemos el valor de fallo
		int resultado =-1;
		PreparedStatement pStmt;

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

	
			query = "DELETE FROM PASAJEROS WHERE idpasajeros = ?";
			
			pStmt = con.prepareStatement(query);

			pStmt.setInt(1, idPasajero);
			
			resultado = pStmt.executeUpdate();		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultado=-1;
			return resultado;
		}
		// Cerramos las conexiones activas
		try {
			pStmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

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

	
	public boolean modificarPasajero(pasajeroVO pasajero, boolean modBussiness)

	{
		// Variables
		int numMod=-1;
		String query = "";
		PreparedStatement pStmt;
		boolean modCorrecto= false;
		boolean anterior=false;
		

		// Conectamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			
			query = "UPDATE pasajeros SET";
			
			//Añadimos al update los campos a modificar
			if (pasajero.getDni()!=null)
			{
				query= query + " dni='" +pasajero.getDni() +"'";
				anterior=true;
			}
			
			
			if (pasajero.getEdad()!=0)
			{
				if (anterior) query= query + " , ";
				else anterior=true;
				query= query + " edad=" +pasajero.getEdad();

			}
			if (pasajero.getNombre()!=null)
			{
				if (anterior) query= query + " , ";
				else anterior=true;
				query= query + " nombre='" +pasajero.getNombre() +"'";
				
			}
			
			if (modBussiness)
			{
				if (anterior) query= query + " , ";
				else anterior=true;
	
				query= query + " bussiness=" +pasajero.isBusiness();
			}
			
			query = query + " WHERE idpasajeros=? ";
			
			//Añadimos el id pasajero al preparedStatement
			pStmt = con.prepareStatement(query);
			
			pStmt.setInt(1, pasajero.getIdPasajero());
			//Ejecutamos la query
			numMod = pStmt.executeUpdate();
			
			//Si nos devuelve 1 pasajero modificado
			//Ha ido todo bien
			if (numMod==1)
				modCorrecto=true;
			
		
			pStmt.close();
			

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
		return modCorrecto;
	}
	
}
