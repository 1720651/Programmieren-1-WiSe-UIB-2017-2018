package Bankprojekt.Hummelbank.de.hsma.pr1.banking.domain;

public class Bankkonto {
	private final String kontonummer;
	private int kreditlimit;
	private double kontostand = 0;
	private String inhaber;
	private String währung;
	
	// soll nur im Bank-Package sichtbar sein
	Bankkonto(String kontonummer, int kreditlimit, String inhaber, String währung) {
		this.kontonummer = kontonummer;
		this.kreditlimit = kreditlimit;
		this.inhaber = inhaber;
		this.währung = währung;
	}
	
	String getKontonummer() {
		return kontonummer;
	}
	double getMaxAbhebung() {
		return kreditlimit + kontostand;
	}
	double getKontostand() {
		return kontostand;
	}
	String getInhaber() {
		return inhaber;
	}

	String getWährung() {
		return währung;
	}
	
	void geldEinzahlen(double betrag) {
		kontostand += betrag;
	}
	
	void geldAuszahlen(double betrag) {
		if (kontostand + kreditlimit >= betrag) {
			kontostand -= betrag;
		} else {
			throw new RuntimeException("Konto nicht ausreichend gedeckt!");
		}
	}
	
}
