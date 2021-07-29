package uebungen.aufgaben;
import java.util.Scanner;

public class _Exercise7 {

	public static void main(String[] args) {
		System.out.println("<<< WILLKOMMEN BEI UNSEREM RATESPIEL >>>");
		System.out.println(" Sie überlegen sich eine Zahl, die zwischen 1 und 100 liegen soll." + "\n" +  "Jedoch sollte ihre Zahl ein Element der natürlichen Zahlen sein.");
		Scanner scglobal = new Scanner(System.in);
		System.out.println("Jetzt denken sie sich bitte eine Zahl aus !!! ");	
		int counter = 0;
		int startobergrenze = (101);
		int startuntergrenze = (0);
		whileGame(scglobal, counter, startobergrenze, startuntergrenze);
		
	}
	
	public static void recGame(Scanner scglobal, int counter, int obergrenze, int untergrenze) {
		int refreshedcounter = (++counter);
			System.out.println("Ist ihre Zahl " + ((obergrenze+untergrenze)/2) + " ?" + "\n" + "Wenn nicht, ist sie größer oder kleiner ? (j, g, k)");
			String answer = scglobal.nextLine();
			if (answer.equals("j"))
				System.out.println("ICH HABE IHRE ZAHL NACH " + refreshedcounter + " VERSUCH(EN) ERRATEN !");
			else if (answer.equals("g"))
				recGame(scglobal, refreshedcounter, obergrenze, (obergrenze+untergrenze)/2);
			else if (answer.equals("k"))
				recGame(scglobal, refreshedcounter, ((obergrenze+untergrenze)/2), untergrenze);
						
		}
	
	public static void whileGame(Scanner scglobal, int counter, int obergrenze, int untergrenze) {
		while (true) {
			int refreshedcounter = (++counter);
			System.out.println("Ist ihre Zahl " + ((obergrenze+untergrenze)/2) + " ?" + "\n" + "Wenn nicht, ist sie größer oder kleiner ? (j, g, k)");
			String answer = scglobal.nextLine();
			if (answer.equals("j")) {
				System.out.println("ICH HABE IHRE ZAHL NACH " + refreshedcounter + " VERSUCH(EN) ERRATEN !");
				break;
			}
			else if (answer.equals("g"))
				untergrenze = ((obergrenze+untergrenze)/2);
			else if (answer.equals("k"))
				obergrenze = ((obergrenze+untergrenze)/2);
				}			
			}
		}
	
	
