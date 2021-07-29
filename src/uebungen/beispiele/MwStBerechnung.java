package uebungen.beispiele;
import java.util.Scanner;

public class MwStBerechnung {

	public static void main(String[] args) {
		//System.out.println("Bitte geben sie den Warentyp an und den Preis : ");
		Scanner sc = new Scanner(System.in);
		//String ware = sc.nextLine();
		//double preis = sc.nextDouble();
		sc.close();
		//berechner(ware, preis);
		tester("Lebensmittel", 1.0);
		
	}

	public static double berechner(String ware, double preis) {
		if(ware.equals("Lebensmittel"))
			return (preis*1.07);
		else
			return (preis*1.19);
	}	

	public static void tester(String ware, double preis) {
		if(berechner(ware, preis) == 1.07)
			System.out.println("Umrechnung passt !");
		else
			System.out.println("Umrechnung passt nicht !");
	}	



}
