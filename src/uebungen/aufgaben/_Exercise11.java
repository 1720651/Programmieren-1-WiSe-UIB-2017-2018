package uebungen.aufgaben;
import java.util.Random;
import java.util.Scanner;

import uebungen.beispiele.SHA1Hash;

public class _Exercise11 extends SHA1Hash {

	public static void main(String[] args) {
		Scanner scglobal = new Scanner(System.in);
		System.out.println("EINGABE : STRING | NULLSTELLEN");
		System.out.print(findHashWithLeadingZeros(scglobal.nextLine(), scglobal.nextInt()) );
		scglobal.close();
	}
	
	public static String findHashWithLeadingZeros(String s,	int	zeros) {
		int counter = 0;
		boolean gefunden = false;	
		String zero = stringwithzeros(zeros);
		while(!gefunden) {
			if( (hash(s).substring(0, zeros).equals(zero)) ){
					gefunden = true;
			}
			else {
				counter++;
				Random randomchar = new Random();
				char c = (char) (randomchar.nextInt(95)+32);
				s += (c);
			}		
		}
		System.out.println("HASH-Versuche : " + counter);
		return hash(s);		
	}
	
	public static String stringwithzeros(int zeros) {
		String zero = "";
		for(int j = 0; j!=zeros; j++) {
			zero += '0';	
		}
		
		return zero;
	}
}

