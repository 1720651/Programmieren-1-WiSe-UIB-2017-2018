package Bankprojekt.Hummelbank.de.hsma.pr1.banking.ui;

import java.util.Scanner;

import Bankprojekt.Hummelbank.de.hsma.pr1.banking.domain.Bank;

public class TextUi {
	Bank bank;
	Scanner sc = new Scanner(System.in);

	public TextUi(Bank bank) {
		this.bank = bank;
		hauptmen�();
	}

	private void hauptmen�() {
		int eingabe;

		do {
			System.out.println();
			System.out.println("======================================================================================");
			System.out.println("Herzlichen Willkommen bei ihrem Selbstbedienungsterminal der " + bank.getName());
			System.out.println();
			System.out.println("Bitte wählen Sie eine Funktion:");
			System.out.println();
			System.out.println("1 = Konto anlegen");
			System.out.println("2 = Geld einzahlen");
			System.out.println("3 = Geld auszahlen");
			System.out.println("4 = Geld überweisen");
			System.out.println("5 = Kontostand abfragen");
			System.out.println("6 = Beenden");

			eingabe = sc.nextInt();

			try { // nicht prüfungsrelevant, nur damit Sie es einmal gesehen haben
				switch (eingabe) {
				case 1:
					formularKontoAnlegen();
					break;
				case 2:
					formularGeldEinzahlen();
					break;
				case 3:
					formularGeldAuszahlen();
					break;
				case 4:
					formularGeldÜberweisen();
					break;
				case 5:
					formularKontostandAbfragen();
					break;
				case 6:
					break;
				default:
					System.out.println("Eingabe nicht erkannt!");
				}
			} catch (Exception e) {
				System.err.println("Fehler: " + e.getMessage());
			}
			
			waitAMoment();

		} while(eingabe != 6);

		sc.close();

	} // hauptmenü

	private void formularKontoAnlegen() {
		String währung = "EUR"; 		// im Moment noch fix

		System.out.println("-> Konto anlegen (in " + währung + ")");
		System.out.println();
		System.out.println("Bitte geben Sie den Namen des Kontoinhabers an (leere Eingabe -> Abbruch): ");
		String inhaber = sc.next();
		// in der echten Welt würden wir hier sicher noch Vorname, Geburtsdatum u.ä. abfragen

		if (inhaber.length() != 0) {
			String ktoNr = bank.kontoAnlegen(inhaber, währung);
			System.out.println("Konto anlegen erfolgreich, Ihre Kontonummer lautet: " + ktoNr);
		} else {
			System.out.println("Konto anlegen abgebrochen.");
		}		
	}

	private void formularGeldEinzahlen() {
		System.out.println("-> Geld einzahlen");
		
		String ktoNr = kontonummerEingeben("Zielkontos");
		double betrag = betragEingeben(ktoNr, "Einzahlungsbetrag");
		bank.geldEinzahlen(ktoNr, betrag);
		
		System.out.println("Geld erfolgreich verbucht.");
	}

	private void formularKontostandAbfragen() {
		System.out.println("-> Kontostand abfragen");
		
		String ktoNr = kontonummerEingeben("Zielkontos");
		
		System.out.println("Ihr Kontostand beträgt: " + bank.getKontostand(ktoNr) + " " + bank.getW�hrung(ktoNr));
	}

	private void formularGeldAuszahlen() {
		System.out.println("-> Geld auszahlen");

		String ktoNr = kontonummerEingeben("Quellkontos");
		double betrag = betragEingeben(ktoNr, "Auszahlungsbetrag");
		bank.geldAuszahlen(ktoNr, betrag);
		
		System.out.println("Auszahlung erfolgreich, bitte entnehmen Sie Ihr Geld.");
	}
	
	
	private void formularGeldÜberweisen() {
		System.out.println("-> Geld überweisen");
		System.out.println();
			
		String ktoNrQ = kontonummerEingeben("Quellkontos");
		String ktoNrZ = kontonummerEingeben("Zielkontos");
		double betrag = betragEingeben(ktoNrQ, "Überweisungssbetrag");

		bank.geld�berweisen(ktoNrQ, ktoNrZ, betrag);
		System.out.println("Überweisung erfolgreich verbucht.");
	}
	
	private String kontonummerEingeben(String typ) {
		System.out.println();
		System.out.println("Bitte geben Sie nun die Kontonummer des " + typ + " an (leere Eingabe -> Abbruch): ");
		String ktoNr = sc.next();
		if (ktoNr.length() == 0) {
			throw new RuntimeException("Vorgang abgebrochen.");
		}
		return ktoNr;
	}
	
	private double betragEingeben(String ktoNr, String typ) {
		String w�hrung;
		w�hrung = bank.getW�hrung(ktoNr);
		System.out.println("Bitte geben Sie den " + typ + " in " + w�hrung + " ein: ");
		return sc.nextDouble(); 
	}
	
	private void waitAMoment() {
		// nur damit Fehlermeldungen nicht erst nach dem Menü erscheinen
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
