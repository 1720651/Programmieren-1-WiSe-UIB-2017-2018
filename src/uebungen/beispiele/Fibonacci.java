package uebungen.beispiele;

public class Fibonacci {

	public static void main(String[] args) {
		int wert  = 1;
		int vorwert = 1;
		System.out.println(vorwert);
		System.out.println(wert);
		fiboself(vorwert, wert);
		fibotutor();
		
	}
	//Mit einem eingebauten Counter, jedoch auch anders möglich mit Typbegrenzung
	public static void fiboself(int a, int b) {
		int i = 10;
		int counter = 0;
		while(counter!=i) {
			int c = (a+b);
			System.out.println(c);
			a = c;
			b = (c-b);
			counter = (counter+1);
						
		}
	}
	
	public static void fibotutor() {
		long z1 = 1, z2 = 1;
		System.out.println(z1);
		do {
			System.out.println(z2 + "\t" + ((double)z2/z1));
			long tmp = z2;
			z2 = z1 + z2;
			z1 = tmp;			
		} while (z2 < 1000);
		
		
	}
		
		
	}

