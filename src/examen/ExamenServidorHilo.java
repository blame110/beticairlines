package examen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import model.BilleteDAO;
import model.VueloDAO;
import model.pasajeroDAO;
import model.pasajeroVO;

public class ExamenServidorHilo extends Thread {

	private Socket sockCliente = null;

	public ExamenServidorHilo(Socket socket) {
		// TODO Auto-generated constructor stub
		// Guardamos el socket para que el hilo se comunique
		// Con su cliente
		sockCliente = socket;
	}

	public void run() {

		DataOutputStream dos = null;
		DataInputStream dis = null;
		ObjectInputStream odis = null;
		int opcionElegida = -1;

		// Abrimos los canales de comunicacion
		try {

			dos = new DataOutputStream(sockCliente.getOutputStream());
			dis = new DataInputStream(sockCliente.getInputStream());

			// Menu principal
			while (opcionElegida != 4) {

				// Leemos la opción que el cliente ha elegido
				opcionElegida = dis.readInt();

				switch (opcionElegida) {
				case 1:

					int idVuelo = 0;
					// Leemos el idVuelo que el cliente selecciona
					// Para eliminar
					idVuelo = dis.readInt();
					VueloDAO vuelo = new VueloDAO();

					if (vuelo.eliminarVuelo(idVuelo))
						dos.writeUTF("El Vuelo " + idVuelo + " ha sido eliminado correctamente");
					else
						dos.writeUTF("El Vuelo " + idVuelo + " no existe");

					break;
					
				//Actualizacion
				case 2:
					
					try {
						boolean modBusiness = false;
						pasajeroDAO pasajerodao = new pasajeroDAO();
						
						//Leemos el pasajeroVO
						odis = new ObjectInputStream(sockCliente.getInputStream());
						pasajeroVO pasajero = (pasajeroVO) odis.readObject();
						
						//leemos si hay que modificar el campo business
						modBusiness = (dis.readUTF()).toUpperCase().equals("S");
						
						//Llamamos a modificar pasajero
						pasajerodao.modificarPasajero(pasajero, modBusiness);
						
						odis.close();
						
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					break;


				// Queremos mostrar los billetes
				case 3:

					int idAvion = 0;
					String nomAeropuerto = "";

					// Leemos los datos que envia el cliente
					idAvion = dis.readInt();
					nomAeropuerto = dis.readUTF();
					BilleteDAO billete = new BilleteDAO();
					billete.mostrarBilletes(idAvion, nomAeropuerto);

					break;

				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
