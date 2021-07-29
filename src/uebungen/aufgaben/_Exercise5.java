package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise5 {

	public static void main(String[] args) {
		Scanner scglobal = new Scanner(System.in);
		System.out.println("Geben sie das Jahr an, von welchem sie das Datum des Osterfests wissen möchten. ");
		int year = scglobal.nextInt();
		scglobal.close();
		if(year < 1582)
			System.out.println("Leider ist eine Berechnung (wg. der Kalderreform) nur ab 1582 möglich!!! ");
		else {
			int g = (year%19);
			int c = (year/100);
			int h = ((c-(c/4)-((8*c+13)/25)+(19*g)+15)%30);
			int i = (h-(h/28)*(1-((29/(h+1))*((21-g)/11))));
			int j = ((year+(year/4)+i+2-c+(c/4))%7);
			int l = (i-j);
			int month = (3+((l+40)/44));
			int day = (l+28-31*(month/4));
			System.out.println("Das Osterfest ist am: " + day + "." + month + "." + year);
			
		
		
		
		}

	}

}
