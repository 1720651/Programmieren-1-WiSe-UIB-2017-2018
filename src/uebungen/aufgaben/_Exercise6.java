package uebungen.aufgaben;
import java.util.Scanner;


public class _Exercise6 {
	public static void main(String[] args) {
		Scanner scglobal = new Scanner(System.in);
		System.out.println("Geben sie das Skala von ihrer gewünschten Temperatureinheit ein. (Celsius, Kelvin oder Fahrenheit.)");
		String skala = scglobal.nextLine();
		System.out.println("Geben Sie den Temperaturwert für " + skala + " ein.");	
		double tempwert = scglobal.nextDouble();
		scglobal.close();
		umrechnungTempwertSkala(tempwert, skala);
	}
	
	static void umrechnungTempwertSkala(double tempwert, String skala){
		switch (skala) {
		case "Celsius": System.out.println(tempwert + " ° Celsius entspricht " + (tempwert+273.15) + " Kelvin und " + ((tempwert*1.8)+32) + " ° Fahrenheit."); break;
		case "Kelvin":	System.out.println(tempwert + " Kelvin entspricht " + (tempwert-273.15) + " ° Celsius und " + ((tempwert*1.8)-459.67) + " ° Fahrenheit."); break;
		case "Fahrenheit":	System.out.println(tempwert + " ° Fahrenheit entspricht " + ((tempwert-32)/(1.8)) + " ° Celsius und " + (((tempwert+459.67)/(1.8))) + " Kelvin."); break;
		default: System.out.println("Überprüfe nochmal deine Eingabe ! ");
		
		}		
	}	
}