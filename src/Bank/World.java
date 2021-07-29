package Bank;
import java.util.Random;
import java.util.Scanner;

public class World {
	static boolean worldstart = true;
	
	public static void main(String[] args) {
		BankUI GUIBank= new BankUI();
		System.out.println("Willkommen bei ihrer eigenen Welt");
		System.out.println("Sie können hier ihre eigenen Bank verwalten !!! \n");
		Scanner scglobal = new Scanner(System.in);
		System.out.println(" --> Neue Bank anlegen      ");
		System.out.println("---------------------------------");
		System.out.println("Bankname (z.b 'Sparkasse_AG') :  ");
		System.out.println("Eigenkapital (z.b 50.000) : ");
		System.out.println("Sitz mit Kürzel (z.b 'de'oder 'fr') : ");
		System.out.println("---------------------------------");
		Bank newbank = new Bank(scglobal.next(), bicgenerator(scglobal), scglobal.nextFloat(), scglobal.next());
		GUIBank.BankVerwaltenUI(newbank);
	}
	
	public static String bicgenerator(Scanner scglobal) {
		String randombic = "";
		Random bicchar = new Random();
		    for (int i = 0; i < 8; i++) {
		        char c = (char) (bicchar.nextInt('Z' - 'A')+ 'A');
		        randombic += (c);
		    }
		 return randombic;
	}

}
