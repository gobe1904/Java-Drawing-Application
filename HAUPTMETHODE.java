package geo;
import java.util.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class HAUPTMETHODE 
{
	public static void aus(Object O) 
	{
		System.out.println(O);
	}
	
	public static void main(String[] args) 
	{
		Scanner scanner;
		int i;
		
		ArrayList<Pr1Paintable> geo = null;
		scanner = new Scanner(System.in);
		
		BufferedImage bufImg = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
		Graphics gBuf = bufImg.createGraphics();
				
		while (true) //Solange true == true ist, führe die Schleife aus. (Immer der Fall)
		{
			//Begrüßende Ausgabe
			aus("Erwarte Eingabe");
			
			//Eingabe des Scanners in scannerLowerCase speichern, nachdem Methode toLowerCase angewandt wurde
			String scannerLowerCase = scanner.nextLine().toLowerCase(); 
			
			//scannerLowerCase splitten und in StringArray "scannerStringArray" speichern															
			String scannerStringArray[] = scannerLowerCase.split(" ");
			
			//neuen int Array "zahlenArray" erstellen, notwending da Zeichnungen keine Stringwerte akzeptieren
			int zahlenArray[] = new int[scannerStringArray.length];
			
			//String Array in int verwandeln und in zahlenArray speichern	
			for (i = 0; i < scannerStringArray.length - 1 ; i++)
			{															
				zahlenArray[i] = Integer.parseInt(scannerStringArray[i+1]);	
			}
			
			//Wenn die Eingabe "ende" lautet, breche die Schleife ab und springe zum Ende des Systems.			
			if (scannerStringArray[0].equals("ende")) 
			{
							
				System.out.println("Ende des Systems");
				Pr1Frame.paint(geo, 1000, 1000);
				break;
			}
			
			//Wenn die Eingabe "kreis" lautet
			else if (scannerStringArray[0].equals("kreis")) 
			{
				if(scannerStringArray.length == 4) 
				{
					gBuf.drawOval(zahlenArray[0], zahlenArray[1], zahlenArray[2], zahlenArray[2]);
					aus("Punkt mit Mittelpunkt " + zahlenArray[0] + " " + zahlenArray[1] + "und Radius r = " + zahlenArray[2]);
				}
			}
		}
		scanner.close();
	}

}
