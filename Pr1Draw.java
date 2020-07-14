package geo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JLabel;

@SuppressWarnings("serial")


//Enhält alle Logik zum Zeichnen der geometriemetrieobjekte die paintable() implementieren.
public class Pr1Draw extends JLabel 
{

	protected ArrayList<Pr1Paintable> geometrie; //Arraylist des Typen Pr1Paintable mit dem Namen geometrie
	protected int hoehe;
	protected int breite;  //Wird nicht verwendet, aber kann zum Erweitern verwendet werden.
	boolean bB = false;
	public Pr1Draw(ArrayList<Pr1Paintable> geometrie, int breite, int hoehe) 
	{
		this.geometrie = geometrie;
		this.breite = breite;
		this.hoehe = hoehe;		
	}

	protected void paintComponent(Graphics g) 
	{

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.BLACK);
		
		for (int n = 0; n < geometrie.size(); n = n + 1) 
		{
			Pr1Paintable geometrieN = geometrie.get(n); 
			Punkt[] pkt = geometrieN.defPunkte(); // geht weil geometrie immer paintable()

			if (geometrieN instanceof FlaechenGeometrie) g.setColor(Color.RED);
			
			if (geometrieN instanceof Kreis) 
			{ // falls geometrie[n] ein Kreis
				int r = 0;
				//int r = (int) ((int) pkt[0].getX() - pkt[] );
				double u = ((Kreis) geometrieN).umfang();
				if (geometrieN.defPunkte().length == 1 ) 
				{
					double rd = u / (2 * Math.PI); // Radius aus Umfang berechnen
					r = (int) rd;
				}
				else
				{
					Punkt[] kp = geometrieN.defPunkte();
					double rd = Punkt.distance(kp[0], kp[1]);
					r = (int) rd;
				}
				int mX = (int) pkt[0].getX() - r;
				int mY = (int) pkt[0].getY() + r;
				mY = hoehe-mY;

				g.drawOval(mX, mY, r * 2, r * 2);
				repaint();		
			} 
			else 
			{		//geometrie ist ein Punkt
				if (pkt.length == 1) 
				{
					int mX = (int) pkt[0].getX();
					int mY = (int) (hoehe-pkt[0].getY());
					g.fillOval(mX, mY, 10, 10);
					repaint();
				}
				else 
				{   //alle anderen
					for (int m = 0; m < pkt.length - 1; m = m + 1) 
					{
						int x1 = (int) pkt[m].getX();
						int x2 = (int) pkt[m+1].getX();
						int y1 = (int) (hoehe-pkt[m].getY());
						int y2 = (int) (hoehe-pkt[m+1].getY());
						g.drawLine(x1, y1, x2, y2);
					}
					//letzte linie, nicht zeichnen für Linienzug
					
					boolean isL = geometrieN instanceof Linienzug;
					if (isL == false) 
					{
						int xE = (int) pkt[pkt.length - 1].getX();
						int xA = (int) pkt[0].getX();
						int yE = (int) (hoehe-pkt[pkt.length - 1].getY());
						int yA = (int) (hoehe-pkt[0].getY());
						g.drawLine(xE, yE, xA, yA);
					}
					repaint();
				}
				
			}
			
			g.setColor(Color.BLACK);
		}

	}
	
}