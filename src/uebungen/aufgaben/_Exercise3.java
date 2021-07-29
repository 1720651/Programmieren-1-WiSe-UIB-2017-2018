package uebungen.aufgaben;
import java.util.Scanner;


public class _Exercise3 {
	public static void main(String[] args) {
		System.out.println("Page 2 Exercise 3 a) b) or c) ? ");
		Scanner sc = new Scanner(System.in);
		String selection = sc.nextLine();
			if (selection.equalsIgnoreCase("a)")) {
				System.out.println(readline(sc));
			}
			else if (selection.equalsIgnoreCase("b)")) {
				System.out.println(readint(sc));
			}
			else if (selection.equalsIgnoreCase("c)")) {				
				readintandreadline(readline(sc), Integer.toString(readint(sc)));	
			}		

	}

	static String readline(Scanner sc) {
		System.out.println("Geben sie eine Zeichenkette ein : ");
		String zeichenkette = sc.nextLine();
		return zeichenkette;
	}
	
	static int readint(Scanner sc) {
		System.out.println("Geben sie eine Zahl ein : ");
		int zahl = sc.nextInt();
		return zahl;		
	}
	
	static void readintandreadline(String x, String y) {
		if(x.equals(y)){
		System.out.println("Haben den gleichen Wert !");
		}
		else {
			System.out.println("Haben NICHT den gleichen Wert !");
		}
	}
}
	
