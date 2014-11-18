package ud.prog3.cap06;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

@SuppressWarnings("serial")
public class PruebaDibujarLinea extends JPanel {
	private static int anchura = 0;
	private static int altura = 0;
	public PruebaDibujarLinea() {
		setBackground( Color.white );
		addComponentListener( new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				anchura = getWidth();
				altura = getHeight();
			}
		} );
	}
	
	static PruebaDibujarLinea p = new PruebaDibujarLinea();
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		f.setSize( 800, 600 );
		// f.setLocation( new Point(2000,0)); // Cambia la posici�n de la ventana
		f.add( p, BorderLayout.CENTER );
		f.setVisible( true );
		Graphics2D g = (Graphics2D) p.getGraphics();
		dibujarLinea( g, Color.black ); // Por qu� esta no la dibuja?...
		try { Thread.sleep(100); } catch (InterruptedException e) {}
		dibujarLinea( g, Color.blue ); // Y esta s�... pero relativamente...?
	}
	
	private static Random r = new Random();
	
	private static void dibujarLinea(Graphics2D g, Color c) {
		g.setColor( c );
		g.drawLine( r.nextInt(100), r.nextInt(100), anchura - r.nextInt(100), altura - r.nextInt(100));
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		dibujarLinea( (Graphics2D) g, Color.red ); // ...Sin embargo, esta no admite dudas!!
	}
	
}
