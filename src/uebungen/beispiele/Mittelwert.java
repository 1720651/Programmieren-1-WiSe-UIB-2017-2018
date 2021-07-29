package uebungen.beispiele;

public class Mittelwert {

	public static void main(String[] args) {
		int summe = 0;
		
		int i = 1;
		for (; i <= 2; i++) {
			summe += i;
		}
		
		System.out.println("i: " + i);
		System.out.println("Summe: " + summe);
		System.out.println("Mittelwert: " + (summe/(i-1.0)));

	}

}
