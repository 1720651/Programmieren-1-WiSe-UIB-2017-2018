package uebungen.beispiele;
import java.util.Scanner;

public class dualzahlInInt {
	public static void main(String args[]) {
		double c = 0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String e = sc.nextLine();
		for(int cc = 0; cc < e.length(); cc++) {
			if(e.charAt(cc) == ('1')) {
				c = c + Math.pow(2, (e.length()-(cc+1)));
			}
		}
		System.out.println(c);

	}
	
}
