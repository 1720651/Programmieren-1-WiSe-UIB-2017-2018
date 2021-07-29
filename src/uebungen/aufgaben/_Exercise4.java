package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise4 {
	public static void main(String[] args) {
		System.out.println("Page 2 Exercise 4 a) (If) c) (Switch) or d) (Tester) ? ");
		Scanner scglobal = new Scanner(System.in);
		String selection = scglobal.nextLine();
		System.out.println("Geben sie ihre erste Zahl ein : ");
		int intone = scglobal.nextInt();
		System.out.println("Geben sie ihren Rechenoperator ein : ");
		char operator = scglobal.next().charAt(0);
		System.out.println("Geben sie ihre zweite Zahl ein : ");
		int inttwo = scglobal.nextInt();	
		
		if (selection.equalsIgnoreCase("a)"))
				ifrechner(intone, operator, inttwo);
		if (selection.equalsIgnoreCase("c)")) 
				switchrechner(intone, operator, inttwo);
		if (selection.equalsIgnoreCase("d)")) 		
				tester();		
		
		scglobal.close();
	}

	static void ifrechner(int intone, char operator, int inttwo) {	
		if(Character.toString(operator).equals("+"))
			System.out.println(intone + " + " + inttwo + " = " + (intone+inttwo));
		else if(Character.toString(operator).equals("-"))
			System.out.println(intone + " - " + inttwo + " = " + (intone-inttwo));
		else if(Character.toString(operator).equals("*"))
			System.out.println(intone + " * " + inttwo + " = " + (intone*inttwo));
		else if(Character.toString(operator).equals("/"))
			System.out.println(intone + " / " + inttwo + " = " + (intone/inttwo));
		else if(Character.toString(operator).equals("%"))
			System.out.println(intone + " % " + inttwo + " = " + (intone%inttwo));

	}
	
	static void switchrechner(int intone, char operator, int inttwo) {
		switch (operator){
			case '+' : System.out.println(intone + " + " + inttwo + " = " + (intone + inttwo)); break;
			case '-' : System.out.println(intone + " - " + inttwo + " = " + (intone - inttwo)); break;
			case '*' : System.out.println(intone + " * " + inttwo + " = " + (intone * inttwo)); break;
			case '/' : System.out.println(intone + " / " + inttwo + " = " + (intone / inttwo)); break;
			case '%' : System.out.println(intone + " % " + inttwo + " = " + (intone % inttwo)); break;
			default: System.out.println("�berpr�fe deine Angaben !");
			}
	}
	
	static void tester() {
		System.out.println("# 1.1Test +/+ [IF-Methode] Addition //L�sung: 12//");
		ifrechner(5, '+', 7);
		System.out.println("# 1.2 Test +/- [IF-Methode] Addition //L�sung: 49//");
		ifrechner(56, '+', -7);
		System.out.println("# 1.3 Test -/+ [IF-Methode] Addition //L�sung: -50//");
		ifrechner(-57, '+', 7);
		System.out.println("# 1.4 Test -/- [IF-Methode] Addition //L�sung: -81//");
		ifrechner(-44, '+', -37);
		System.out.println("");
		System.out.println("# 2.1 Test +/+ [IF-Methode] Substraktion //L�sung: -2//");
		ifrechner(5, '-', 7);
		System.out.println("# 2.2 Test +/- [IF-Methode] Substraktion //L�sung: 63//");
		ifrechner(56, '-', -7);
		System.out.println("# 2.3 Test -/+ [IF-Methode] Substraktion //L�sung: -64//");
		ifrechner(-57, '-', 7);
		System.out.println("# 2.4 Test -/- [IF-Methode] Substraktion //L�sung: -7//");
		ifrechner(-44, '-', -37);
		System.out.println("");
		System.out.println("# 3.1 Test +/+ [IF-Methode] Multiplikation //L�sung: 35//");
		ifrechner(5, '*', 7);
		System.out.println("# 3.2 Test +/- [IF-Methode] Multiplikation //L�sung: -392//");
		ifrechner(56, '*', -7);
		System.out.println("# 3.3 Test -/+ [IF-Methode] Multiplikation //L�sung: -399//");
		ifrechner(-57, '*', 7);
		System.out.println("# 3.4 Test -/- [IF-Methode] Multiplikation //L�sung: 1628//");
		ifrechner(-44, '*', -37);
		System.out.println("");
		System.out.println("# 4.1 Test +/+ [IF-Methode] Ganzzahl-Division //L�sung: 0//");
		ifrechner(5, '/', 7);
		System.out.println("# 4.2 Test +/- [IF-Methode] Ganzzahl-Division //L�sung: -8//");
		ifrechner(56, '/', -7);
		System.out.println("# 4.3 Test -/+ [IF-Methode] Ganzzahl-Division //L�sung: -8//");
		ifrechner(-57, '/', 7);
		System.out.println("# 4.4 Test -/- [IF-Methode] Ganzzahl-Division //L�sung: 1//");
		ifrechner(-44, '/', -37);
		System.out.println("");
		System.out.println("# 5.1 Test +/+ [IF-Methode] Modulo //L�sung: 5//");
		ifrechner(5, '%', 7);
		System.out.println("# 5.2 Test +/- [IF-Methode] Modulo //L�sung: 0//");
		ifrechner(56, '%', -7);
		System.out.println("# 5.3 Test -/+ [IF-Methode] Modulo //L�sung: -1//");
		ifrechner(-57, '%', 7);
		System.out.println("# 5.4 Test -/- [IF-Methode] Modulo //L�sung: -7//");
		ifrechner(-44, '%', -37);
		System.out.println("");	
		System.out.println("#6 Zufallstest keine gute Methode und deshlab nicht eingesetzt //L�sung: NONE//");
		
		
	}	
		
	
	
	
}
