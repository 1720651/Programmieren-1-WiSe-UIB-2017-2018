package Bankprojekt;

import java.util.LinkedList;

public class Konto extends Waehrung{
	String inhaber;
	String w�hrungsname;
	String w�hrungsk�rzel;
	double wechselkursown;
	
	private final LinkedList<Betrag> transaktionen = new LinkedList<>();
	
	public Konto(String inhaber, String w�hrungsname, String w�hrungsk�rzel, double wechselkursown) {
		super(w�hrungsname, w�hrungsk�rzel, wechselkursown);
		this.inhaber = inhaber;
		this.w�hrungsname = w�hrungsname;
		this.w�hrungsk�rzel = w�hrungsk�rzel;
		this.wechselkursown = wechselkursown;
	
	}

	public String getInhaber() {
		return inhaber;
	}

	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	void buche(Betrag neueTransaktion) {
		if(neueTransaktion.W�hrung.equals(this.w�hrungsname))
			transaktionen.add(neueTransaktion);
		else {
			Betrag umgerechnerterBetrag = new Betrag((double) umrechnen(neueTransaktion.Betrag/100, this.w�hrungsname),this.w�hrungsname);
			transaktionen.add(umgerechnerterBetrag);
		}	
	}
	
	long saldo(){
		long summe = 0;
		for(Betrag i:transaktionen){
			summe+=i.Betrag;
		}
		return summe;
		
	}
	
	double gebuehren(long saldo, double promille){
		return (saldo-(saldo*(promille/1000)))/100;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Kontoinhaber: " + this.inhaber + "\n" + "W�hrung: " + this.w�hrungsname + "\n" + "------------" + "\n");
		for(Betrag i:transaktionen){
			sb.append(i.toString() + "\t" + "[" + this.w�hrungsk�rzel + "]" + "\n");
		}
		sb.append("------------" + "\n" + "Saldo: " + (double) saldo()/100 + " [" + this.w�hrungsk�rzel + "]");
	return sb.toString();
	}
	
}
