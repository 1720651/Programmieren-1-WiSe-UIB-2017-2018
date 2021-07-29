package Bank;

import java.util.Scanner;

public class AccountUI {
	public void KontoVerwaltenUI(BankAccount account, Bank createdbank) {
		boolean kontoverwaltung=true;
		while(kontoverwaltung) {
			System.out.printf(" --> Willkommen %s %s \n", account.firstname, account.secondname);
			System.out.println("1.) Kontostand ausgeben          ");
			System.out.println("2.) Geld einzahlen               ");
			System.out.println("3.) Geld auszahlen               ");
			System.out.println("4.) Verwaltung beenden           ");
			Scanner scglobal = new Scanner(System.in);
			int auswahl = scglobal.nextInt();
			if(auswahl==1) 
				System.out.println("Der Kontostand beträgt " + account.getMoney());
			else if(auswahl==2)
				KontoEinzahlenUI(scglobal, account);
			else if(auswahl==3)
				KontoAuszahlenUI(scglobal, account, createdbank);
			else if(auswahl==4)
				kontoverwaltung=false;
			else
				System.err.println("Keine richtige Eingabe. \n");
		}
	}
	
	public void KontoEinzahlenUI(Scanner scglobal, BankAccount account) {
		System.out.println("Geben sie ihren Geldbetrag ein (z.b '100'):  ");
		float moneyplus = scglobal.nextFloat();
		System.out.println("Der Kontostand von beträgt " + account.kontoEinzahlen(moneyplus));
		}
	
	public void KontoAuszahlenUI(Scanner scglobal, BankAccount account, Bank createdbank) {
		System.out.println("Geben sie ihren Geldbetrag ein (z.b '500'):  ");
		float moneyminus = scglobal.nextFloat();
		if( (account.money-moneyminus)>=(-account.limit) ) {
			if(createdbank.bankproofmoney(moneyminus)) {
				System.out.println("Ihr Kontostand beträgt : " + account.kontoAuszahlen(moneyminus));
			} else
				System.out.println("Die Bank hat nicht genug Rücklagen");
		} else
			System.out.println("Sie haben ihre Überziehungsgrenze (Limit) erreicht");

		
		
	}
}
