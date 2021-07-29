package uebungen.beispiele;
import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		float BMI;
		Scanner sc = new Scanner(System.in);
		System.out.println("Geben sie ihre Gewicht und ihre Größe an : ");
		float körpergröße = sc.nextFloat();
		int gewicht = sc.nextInt();
		BMI = (gewicht/(körpergröße*körpergröße));
		sc.close();
		System.out.println(BMI);
		
		

	}

}
