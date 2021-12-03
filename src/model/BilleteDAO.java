package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConexionBD;

public class BilleteDAO {
	
	

	public BilleteDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void mostrarBilletes(int idAvion, String nomAeropuerto)

	{
		// Variables
		ResultSet res;
		String query = "";
		PreparedStatement pStmt;

		// Concetamos a la base de datos
		Connection con = ConexionBD.conectarBD();

		try {

			// Creamos la consulta
			query = "SELECT Billetes.* FROM Billetes,Vuelos,Aeropuertos WHERE Vuelos.idVuelo=Billete.Vuelos_idvuelo and Aeropuertos.idAeropuertos=Vuelos.idAeropuertoDestino ";
			query = query + "AND Aeropuertos.ciudad=? and Vuelos.idAvion=?";
			// Ejecutamos la query

			pStmt = con.prepareStatement(query);

			// Añadimos los valores
			pStmt.setString(1, nomAeropuerto);
			pStmt.setInt(2, idAvion);

			// Ejecutamos la query
			res = pStmt.executeQuery();

			int i = 1;
		
			//Mostramos los datos de los billetes
			while (res.next()) {
				System.out.println("Datos del Billete " + i + ":");

				System.out.println("IdBillete: " + res.getInt("idBillete"));
				System.out.println("IdPasajero: " + res.getInt("Pasajeros_IdPasajeros"));
				System.out.println("IdVuelo: " + res.getInt("Vuelos_Idvuelo"));
				System.out.println("numAsiento: " + res.getInt("numAsiento"));
				System.out.println("HoraEmbarque: " + res.getDate("horaembarque"));
				System.out.println("tipoComida: " + res.getString("tipoComida"));
				System.out.println("Registrado: " + res.getBoolean("registrado"));
									
				
			}

			//Cerramos el preparedStatement
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
		
	}

}
