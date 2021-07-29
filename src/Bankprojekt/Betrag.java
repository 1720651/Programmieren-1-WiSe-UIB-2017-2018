package Bankprojekt;

import java.text.DecimalFormat;

public class Betrag {
	final long Betrag;
	final String Währung; 
	
	public Betrag(long Betrag, String Währung) {
		this.Betrag = (Betrag*100);
		this.Währung = Währung;
	}
	
	public Betrag(double Betrag, String Währung) {
		this.Betrag = (long) (Betrag*100);
		this.Währung = Währung;
	}
	
	public long addieren(long BetragOne, long BetragTwo) {
		return (BetragOne + BetragTwo);	
	}
	
	public long substarhieren(long BetragOne, long BetragTwo) {
		return (BetragOne - BetragTwo);
	}
	
	public long mutipliziere(long betrag, long multi) {
		return (betrag*multi)/100;
		
	}
	
	public long prozent(long betrag, long prozentwert) {
		return betrag*prozentwert/100;
	}
	
	public long promille(long betrag, long promillewert) {
		return betrag*promillewert/1000;
	}
	
	public long getVorkomma() {
		return (this.Betrag/100);
	}
	
	public long getNachkomma() {
		return (this.Betrag%100);
		
	}
	
	public byte getVorzeichen() {
		if(this.Betrag<0)
			return -1;
		else
			return 1;
	}
	
	public String toString() {
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		String output = myFormatter.format((double) (this.Betrag)/100);
		return output + " " + this.Währung;
	}
	
	public double getAsDouble() {
		return (double) this.Betrag/100;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Betrag other = (Betrag) obj;
		if (Betrag != other.Betrag)
			return false;
		if (Währung == null) {
			if (other.Währung != null)
				return false;
		} else if (!Währung.equals(other.Währung))
			return false;
		return true;
	}

	
	

}	
