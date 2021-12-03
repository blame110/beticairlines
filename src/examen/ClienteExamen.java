package examen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import model.pasajeroVO;

public class ClienteExamen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcionElegida = -1;
		Socket sockCliente = null;
		int puerto = 1234;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		ObjectOutputStream odos = null;
		Scanner teclado = new Scanner(System.in);
		String respServ = "";

		try {
			// Nos conectamos al servidor
			sockCliente = new Socket("localhost", puerto);

			// Abrimos los canales de comunicacion
			dos = new DataOutputStream(sockCliente.getOutputStream());
			dis = new DataInputStream(sockCliente.getInputStream());

			// Menu principal
			while (opcionElegida != 4) {
				// Mostramos el menu
				System.out.println("*********************");
				System.out.println("1. Eliminar Vuelo");
				System.out.println("2. Modificar Pasajero");
				System.out.println("3. Mostrar billetes del aeropuerto Destino y vuelo");
				System.out.println("4. Salir");

				// Le enviamos al servior la opción del menu elegida
				dos.writeInt(opcionElegida);

				switch (opcionElegida) {

				// Eliminar vuelo
				case 1:
					// Pedimos el id de vuelo a eliminar
					int idvuelo = 0;
					System.out.print("Introduce el id del vuelo:");
					idvuelo = teclado.nextInt();
					// Enviamos el id del vuelo a eliminar
					dos.writeInt(idvuelo);

					// Leemos la respuesta del servidor
					respServ = dis.readUTF();
					System.out.println(respServ);

					break;

				// Modificar pasajero
				case 2:

					// Creamos el objeto que guarda los datos
					pasajeroVO pasajero = new pasajeroVO();
					String modificar = "";

					// leemos los datos del pasajero a modificar
					System.out.println("Id del pasajero a modificar:");
					pasajero.setIdPasajero(teclado.nextInt());

					System.out.println("Quieres modificar el nombre(S/N)");

					modificar = teclado.next();
					if (modificar.toUpperCase().equals("S")) {
						System.out.println("nombre del pasajero:");
						pasajero.setNombre(teclado.next());
					} else
						pasajero.setNombre(null);

					System.out.println("Quieres modificar la edad(S/N)");
					modificar = teclado.next();
					if (modificar.toUpperCase().equals("S")) {
						System.out.println("Edad del pasajero a modificar:");
						pasajero.setEdad(teclado.nextInt());
					} else
						pasajero.setEdad(0);

					System.out.println("Quieres modificar el DNI(S/N)");
					modificar = teclado.next();
					if (modificar.toUpperCase().equals("S")) {
						System.out.println("Dni del pasajero a modificar:");
						pasajero.setDni(teclado.next());
					} else
						pasajero.setDni(null);

					System.out.println("El pasajero es Bussiness(S/N)");
					modificar = teclado.next();
					if (modificar.toUpperCase().equals("S")) {
						System.out.println("El pasajero es Bussiness (si/no):");
						pasajero.setBusiness(teclado.next().toUpperCase().equals("SI"));
					} 
					//Enviamos si el pasajero quiere modificarBussiness
					dos.writeUTF(modificar);
					
					//Una vez cargado el pasajeroVO con los datos a modificar, se lo 
					//Enviamos al servidor
					odos.writeObject(pasajero);
					
					// Leemos la respuesta del servidor
					respServ = dis.readUTF();
					System.out.println(respServ);
					
					break;
					
				case 3:
					// Pedimos el id del avion
					int idavion = 0;
					String nombreAeropuerto="";
					
					System.out.print("Introduce el id del avion:");
					idavion = teclado.nextInt();
					// Enviamos el id del vuelo
					dos.writeInt(idavion);
					
					System.out.print("Introduce el nombre del aeropuerto destino:");
					nombreAeropuerto = teclado.next();
					// Enviamos el nombre del aeropuerto
					dos.writeUTF(nombreAeropuerto);
				
					break;

				}
				
				

			}

			// Cerramos la conexion y los recursos
			dis.close();
			dos.close();
			sockCliente.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
