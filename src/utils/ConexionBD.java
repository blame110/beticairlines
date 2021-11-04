package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	/**
	 * Funci�n que conecta con la BD
	 * 
	 * @return Connection o null si ha habido fallos
	 */
	public static Connection conectarBD() {
		Connection con;

		// Parametros de conexi�n
		String url = "jdbc:mysql://localhost/beticairlines";
		String user = "root";
		String password = "toor";

		try {
			// Conectamos con la BD
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
		// devolvemos la conexi�n
		return con;
	}

}
