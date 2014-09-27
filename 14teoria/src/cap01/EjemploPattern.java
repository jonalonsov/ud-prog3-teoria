package cap01;

import java.util.regex.Pattern;

public class EjemploPattern {
	private static String[] testNombres = {
		"prueba.txt", "prueba2.jpg", "otro.dat", "pedro.doc", "dir"
	};
	public static void main(String[] args) {
		// Expresi�n regular de p*.* -->   p .* \. .*
		// Como el car�cter \ en un string en Java es especial, hay que poner \\
		String patron1 = "p.*\\..*";   // Patr�n de la ER
		Pattern pat1 = Pattern.compile( patron1 );  // Se compila
		for (String s : testNombres) {
			if (pat1.matcher(s).matches())  // Se saca un "emparejador" y se comprueba si casa
				System.out.println( s + " cumple el patr�n " + patron1 );
			else 
				System.out.println( "   " + s + " no cumple el patr�n " + patron1 );
		}
	}
}
