package Bank;

import java.util.ArrayList;
public class Bank {
	ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	int uselesscounter = 0;
	String bankname;
	String BIC;
	float bankmoney;
	String residence;
	
	public Bank(String bankname, String BIC, float bankmoney, String residence) {
		this.bankname = bankname;
		this.BIC = BIC;
		this.bankmoney = bankmoney;
		this.residence = residence;
	}
	
	public void KontoErstellen(String vorname, String nachname, String currency, String kontonr) {
		uselesscounter+=1;
		BankAccount newaccount = new BankAccount(vorname, nachname, kontonr,  currency, (10000), (2500) );
		accounts.add(newaccount);
	}
	
	public String neueKontonummer(String res) {
		return (res.charAt(0) + res.charAt(1) + String.format("%06d", (0)) + accounts.size() );
		
	}
		
	public boolean bankproofmoney(float moneyminus) {
		double bankproofmoneyvalue = 0;
		for(int i = 0; i>accounts.size(); i++)
			bankproofmoneyvalue+=accounts.get(i).money;
		return((bankmoney-(bankproofmoneyvalue-moneyminus))>0);
		
	}
}

