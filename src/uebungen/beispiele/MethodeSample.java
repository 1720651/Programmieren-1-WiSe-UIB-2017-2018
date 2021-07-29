package uebungen.beispiele;
import java.util.Scanner;

public class MethodeSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie zwei Zahlen ein: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();

		int result = subtract(x, y);
		System.out.println("Ergebnis: " + result);
	}

	public static int subtract(int a, int b) {
		return a - b;
	}
}
