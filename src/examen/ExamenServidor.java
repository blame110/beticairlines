package examen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import model.BilleteDAO;
import model.VueloDAO;
import model.pasajeroDAO;

import java.net.ServerSocket;

public class ExamenServidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket sockCliente = null;
		ServerSocket servSock = null;
		int puerto = 1234;
		boolean servidorActivo = true;
		ExamenServidorHilo hilo=null;

		try {
			// Creamos el Servidor
			servSock = new ServerSocket(puerto);

			while (servidorActivo) {
				// Aceptamos conexiones de clientes
				sockCliente = servSock.accept();
				
				hilo = new ExamenServidorHilo(sockCliente);
				hilo.start();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
