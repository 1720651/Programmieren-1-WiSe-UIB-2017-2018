package uebungen.beispiele;


public class Loops {

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		
		while (i <= 10) {
			System.out.println("while " + i);
			i++;
		}

		// ---------------
		
		int j = 0;
		for (; j <= 10; j++) {
			System.out.println("for " + j);
		}
		System.out.println("for " + j);
		
		// ---------------
		
		int k = 0;
		do {
			System.out.println("do while " + ++k);
		} while (k <= 10);
 		
	}

}