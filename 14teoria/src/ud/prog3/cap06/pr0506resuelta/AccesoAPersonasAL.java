package ud.prog3.cap06.pr0506resuelta;

import java.util.ArrayList;

public class AccesoAPersonasAL implements ProcesoProbable {

	private ArrayList<Persona> l;

	@Override
	public void init(int tamanyoTest) {
		l = new ArrayList<>();
		for (int i=0; i<tamanyoTest; i++) {
			l.add( new Persona( i*2+1, "Nombre " + i, "Apellido " + i ));
		}
	}

	@Override
	public Object test() {
		int cont = 0;
		for (int i=0; i<l.size(); i++) {
			if (l.contains( new Persona(i,"","") )) cont++;
		}
		System.out.println( "N�mero personas encontradas: " + cont );
		return l;
	}

	/** M�todo de prueba de la clase
	 * @param args
	 */
	public static void main(String[] args) {
		AccesoAPersonasAL proc = new AccesoAPersonasAL();
		long tiempo = BancoDePruebas.realizaTest( proc, 50000 );
		int espacio = BancoDePruebas.getTamanyoTest( proc );
		System.out.println( "Prueba ArrayList de 50000 -- tiempo: " + tiempo + " msgs. / espacio = " + espacio + " bytes.");
	}

}
