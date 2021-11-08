package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.pasajeroVO;

public class ClienteAir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket sock;
		pasajeroVO ruben;

		try {
			// Nos conectamos con el servidor
			sock = new Socket("localhost", 1234);

			// Creamos un ObjectOutputStream para enviar el objeto
			ObjectOutputStream odos = new ObjectOutputStream(sock.getOutputStream());

			ruben = new pasajeroVO(2, "Rubén", 19, "3453434F", true);

			odos.writeObject(ruben);

			// Cerramos el socket
			sock.close();
			odos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
