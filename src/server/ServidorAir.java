package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.pasajeroVO;

public class ServidorAir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket sockCliente = null;
		ServerSocket servSock = null;
		pasajeroVO rubenOtro = null;
		ObjectInputStream ois = null;

		try {

			// Abrimos las conexiones
			servSock = new ServerSocket(1234);
			// Esperamos al cliente
			sockCliente = servSock.accept();

			ois = new ObjectInputStream(sockCliente.getInputStream());

			rubenOtro = (pasajeroVO) ois.readObject();

			System.out.println(rubenOtro);

			// Cerramos las conexiones
			sockCliente.close();
			servSock.close();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException nfe) {

			nfe.printStackTrace();
		}

	}

}
