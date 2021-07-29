package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise8 {

	public static void main(String[] args) {
		System.out.println("Page 5 Exercise 8 a) b) or c) ? ");
		Scanner scglobal = new Scanner(System.in);
		String selection = scglobal.nextLine();
			if (selection.equalsIgnoreCase("a)")) {
				int[] x = arraysave(scglobal);
				indexcounter(x);
			}
			else if (selection.equalsIgnoreCase("b)")) {
				System.out.println("Die Summme der eigegeben Zahlen beträgt : " + arraysummieren(scglobal, arraysave(scglobal)));			
			}
			else if (selection.equalsIgnoreCase("c)")) {				
				arraytester(scglobal);
			}		
	}
	
	public static void indexcounter(int[] x) {
		for(int i=0; i<x.length; ++i) {
			System.out.print(x[i]+" ");	
			}	
	}
	
	public static int[] arraysave(Scanner scglobal) {
		System.out.println("Geben sie ihre 10 Zahlen ein.");
		int[] x = new int[10];
		for (int i=0; i<=9; i++) {
			int newint;
			newint = scglobal.nextInt();
			x[i] = newint;
		}
		return x;
	}
	
	public static int arraysummieren(Scanner scglobal, int[] arrays) {
		int summe = 0;
		for (int zahl : arrays) {
			summe += zahl;
		}
		return summe;
	}
	
	public static void arraytester(Scanner scglobal) {
		System.out.println("Wir starten einen Test");
		int[][] tester = {{1, 1, 1, 1, 1, 1, 1 ,1 ,1 ,1}, {-5, -77, 56, -23, -23}, {}, {1, -2, (3*4), 44}};
		for(int c=0; c!=4; c++) { 
			indexcounter(tester[c]);
			System.out.println("  Summieren sie diese Zahlenkette per Hand/Internetrechner und geben sie Ihr Ergebnis hier ein : ");
			int testprüfungperhand = scglobal.nextInt();
			if ( (arraysummieren(scglobal, tester[c])) == testprüfungperhand)
				System.out.println("Da " + (arraysummieren(scglobal, tester[c]) + " = " + testprüfungperhand + " ist, war dieser Test erfolgreich."));
			else;
				System.out.println("Da " + (arraysummieren(scglobal, tester[c]) + " != " + testprüfungperhand + " ist, war dieser Test nicht erfolgreich oder ihre Eingabe falsch."));
		}
	}
}
	