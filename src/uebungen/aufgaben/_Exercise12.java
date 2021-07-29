package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise12 {
	
	public static void main(String[] args) {
		Scanner scglobal = new Scanner(System.in);
		String [] zeichenketteleer = new String[10];
		String [] zeichenkettevoll = zeichenüberprüfung(zeichenketteleer, scglobal);
		//ausgabezeichekette(zeichenkettevoll);
		bubblesort(zeichenkettevoll);
		
	}
	
	public static String [] zeichenüberprüfung(String[] zeichenkette, Scanner scglobal) {
		System.out.println("EINGABE : 10 Zeichenketten UND mind. 3 Buchstaben");
		for(int i = 0; i!=10; i++) {
			String eingabe = scglobal.nextLine();
			
			if(eingabe.length()==0) {
				System.out.println("UNGÜLTIGE EINGABE !!!"); 
				break;
			}
			else if (eingabe.length()<=3) {
				System.out.println("Bitte MEHR als 3 Buchstaben/Zeichen !!!"); 
				--i;
			}
			else {
				zeichenkette[i] = eingabe;	
			}
		}
		return zeichenkette;
	}
	
	public static void ausgabezeichekette(String[] zeichenkettevoll) {
		for(String s:zeichenkettevoll) {
			System.out.print(s + " ");
		}	
		//System.out.println("");
	}
	
	public static void bubblesort(String[] zeichenkette) {
		for(int j=0; j < 3; j++) {
			for(int z = 0; z < 9; z++) {
				for(int x = 0; x < 9; x++) {
					if(( (zeichenkette[x+1].charAt(j)) > (zeichenkette[x].charAt(j)) )) {
						zeichenkette = switcharray(zeichenkette, x);
					}
				}
			}
			System.out.println("Bubblesort nach dem " + (j+1) + "ten Buchstaben -> ");
			ausgabezeichekette(zeichenkette);	
			System.out.println("");

		}
	}
	
	public static String[] switcharray(String[] switcharray, int count) {
		String tmp = switcharray[count];
		switcharray[count] = switcharray[count+1];
		switcharray[count+1] = tmp;
		return switcharray;
	}

}