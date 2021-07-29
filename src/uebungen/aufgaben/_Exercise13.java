package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise13 {
	
	public static void main(String[] args) {
		Scanner scglobal = new Scanner(System.in);
		long zuquerzahl = scglobal.nextLong();
		System.out.println(quersumme(zuquerzahl));
		scglobal.close();
	}
	
	public static long quersumme(long zahl){
		long result = 0;
		for(long i = zahl; i > 0; i = i/10) {
			long rest = i%10;
			result += rest;
			}
		return result;
	}
}
		
	
