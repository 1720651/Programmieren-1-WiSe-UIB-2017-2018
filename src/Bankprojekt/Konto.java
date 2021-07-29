package Bankprojekt;

import java.util.LinkedList;

public class Konto extends Waehrung{
	String inhaber;
	String währungsname;
	String währungskürzel;
	double wechselkursown;
	
	private final LinkedList<Betrag> transaktionen = new LinkedList<>();
	
	public Konto(String inhaber, String währungsname, String währungskürzel, double wechselkursown) {
		super(währungsname, währungskürzel, wechselkursown);
		this.inhaber = inhaber;
		this.währungsname = währungsname;
		this.währungskürzel = währungskürzel;
		this.wechselkursown = wechselkursown;
	
	}

	public String getInhaber() {
		return inhaber;
	}

	public void setInhaber(String inhaber) {
		this.inhaber = inhaber;
	}

	void buche(Betrag neueTransaktion) {
		if(neueTransaktion.Währung.equals(this.währungsname))
			transaktionen.add(neueTransaktion);
		else {
			Betrag umgerechnerterBetrag = new Betrag((double) umrechnen(neueTransaktion.Betrag/100, this.währungsname),this.währungsname);
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
		sb.append("Kontoinhaber: " + this.inhaber + "\n" + "Währung: " + this.währungsname + "\n" + "------------" + "\n");
		for(Betrag i:transaktionen){
			sb.append(i.toString() + "\t" + "[" + this.währungskürzel + "]" + "\n");
		}
		sb.append("------------" + "\n" + "Saldo: " + (double) saldo()/100 + " [" + this.währungskürzel + "]");
	return sb.toString();
	}
	
}
