package Bank;
import java.util.Scanner;

public class BankUI {
	AccountUI GUIAccount = new AccountUI();
	public void BankVerwaltenUI(Bank createdbank) {
		boolean bankverwalten = true;
		while(bankverwalten) {
			System.out.printf(" --> Willkommen bei der %s Bank \n", createdbank.bankname);
			System.out.println("1.) Konto erstellen              ");
			System.out.println("2.) Konto verwalten              ");
			System.out.println("3.) Überweisen                   ");
			System.out.println("4.) Counter ausgeben             ");
			Scanner scglobal = new Scanner(System.in);
			int auswahl = scglobal.nextInt();
			if(auswahl==1) 
				KontoErstellenUI(scglobal, createdbank.neueKontonummer(createdbank.residence), createdbank);
			else if(auswahl==2){
				System.out.printf(" Geben sie ihre Kontonummer ein : ");
				String proofkontonummer = scglobal.next();
				for(int i = 0; i<createdbank.accounts.size(); i++) {
					if(createdbank.accounts.get(i).kontonummer.equals(proofkontonummer))
						GUIAccount.KontoVerwaltenUI(createdbank.accounts.get(i), createdbank);
					}
			}
			else if(auswahl==3) {
				System.out.println(" Geben sie ihre Kontonummer ein : ");
				String proofkontonummer = scglobal.next();
				System.out.println(" Geben sie die Kontonummer des Empfängers ein : ");
				String proofkontonummer2 = scglobal.next();
				for(int i = 0; i<createdbank.accounts.size(); i++) {
					if(createdbank.accounts.get(i).kontonummer.equals(proofkontonummer))
						for(int j = 0; j<createdbank.accounts.size(); j++) {
							if(createdbank.accounts.get(j).kontonummer.equals(proofkontonummer2)) {
								System.out.println(" Überweisungsbetrag : ");
								createdbank.accounts.get(i).kontoAuszahlen(scglobal.nextFloat());
								createdbank.accounts.get(j).kontoEinzahlen(scglobal.nextFloat());				
								}
							}
						}
				}
			
			else if(auswahl==4)
				System.out.println(createdbank.uselesscounter);
			else
				System.err.println("Keine richtige Eingabe. \n");
		}	
	}
	
	public void KontoErstellenUI(Scanner scglobal, String kontonr, Bank createdbank) {
		System.out.println(" --> Neues Konto erstellen       ");
		System.out.println("---------------------------------");
		System.out.println("Dein Vorname :  ");
		System.out.println("Dein Nachname :  ");
		System.out.println("Währung (z.B Euro oder Dollar) : ");
		System.out.println("----------------------------------");
		createdbank.KontoErstellen(scglobal.next(), scglobal.next(), scglobal.next(), kontonr);
		}
}
