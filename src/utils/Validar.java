package utils;

public class Validar {
	
	public static boolean esNumero(String cadena)
	{
		//Por defecto suponemos que es un numero
		boolean esNumerico=true;
		
		try {
			
			//Si falla al convertirlo a numero es que no es completamente n�merico
			//Saltara la excepci�n
			int num = Integer.valueOf(cadena);
			
		}catch (NumberFormatException e)
		{
			esNumerico = false;
			return esNumerico;
		}
		
		return esNumerico;
	}

}
