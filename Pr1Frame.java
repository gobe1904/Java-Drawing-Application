package geo;

import java.util.ArrayList;

import javax.swing.JFrame;
//Definiert das Fenster in dem die Zeichnung erscheint
public class Pr1Frame 
{
	public static void paint(ArrayList <Pr1Paintable> geo, int breite, int hoehe) 
	{
//geo enthält alle Geometrischen Formen die gezeichnet werden sollen.
//x und y definieren die Fenstergröße		
		JFrame frame = new JFrame("Grafikausgabe");
		frame.setSize(breite,hoehe);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.isAutoRequestFocus();
		
		Pr1Draw drawing = new Pr1Draw(geo, breite, hoehe);
		drawing.setBounds(0,0,breite,hoehe);
		drawing.setVisible(true);
		frame.add(drawing);
	}
}
