package uebungen.beispiele;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		float BMI;
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben sie ihre Gewicht und ihre Gr��e an : ");
		float k�rpergr��e = sc.nextFloat();
		int gewicht = sc.nextInt();
		BMI = (gewicht/(k�rpergr��e*k�rpergr��e));
		sc.close();
		System.out.println(BMI);
		
		

	}

}
