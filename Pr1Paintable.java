package geo;

//Jede Geometrieklasse die gezeichnet werden soll muss paintabel implenmentieren.
public interface Pr1Paintable 
{
Punkt[] defPunkte();

//Mit dieser Methode gibt das Objekt alle definierenden Punkte an die Zeichenanwendung weiter. 
//
//Kreis: der Mittelpunkt und je nach Konstruktor weitere Punkte.
//Vieleck oder Dreieck: jeder Eckpunkt
//Box: Die Eckpunkte in der Reihenfolge „unten links, unten rechts, oben rechts, oben links“
//Punkt: Der Punkt selbst
//Line: Der Anfangs- und der Endpunkt
//Linienzug: Zusätzlich noch jeder Zwischenpunkt
// Wie aus Aufgabe 8, sollte bereits vorhanden sein.
}
