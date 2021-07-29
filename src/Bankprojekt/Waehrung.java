package Bankprojekt;

public class Waehrung {
	private final String währungsname;
	private final String währungskürzel;
	private final double wechselkursown;
	
	public Waehrung(String währungsname, String währungskürzel, double wechselkursown) {
		this.währungsname = währungsname;
		this.währungskürzel = währungskürzel;
		this.wechselkursown = wechselkursown;

	}

	public String getWährungsname() {
		return währungsname;
	}

	public String getWährungskürzel() {
		return währungskürzel;
	}
	
	public double getWechselkursown() {
		return wechselkursown;
	}

	
	double umrechnen(double Betrag, String wechselWährung) {
		
		switch(wechselWährung) {
			case "euro":
				return ((Betrag*this.wechselkursown)/ Waehrungen.euro.wechselkursown);
			case "usdollar":
				return ((Betrag*this.wechselkursown)/ Waehrungen.usdollar.wechselkursown);
			case "yen":
				return ((Betrag*this.wechselkursown)/ Waehrungen.yen.wechselkursown);
			case "franken":
				return ((Betrag*this.wechselkursown)/ Waehrungen.franken.wechselkursown);
			case "rubel":
				return ((Betrag*this.wechselkursown)/ Waehrungen.rubel.wechselkursown);
			default:
				return Betrag;
		}
	
	}	
	
	public String toString() {
		return (währungsname + " [" + währungskürzel + "] " + " = " + wechselkursown + " US-Dollar");	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Waehrung other = (Waehrung) obj;
		if (Double.doubleToLongBits(wechselkursown) != Double.doubleToLongBits(other.wechselkursown))
			return false;
		if (währungskürzel == null) {
			if (other.währungskürzel != null)
				return false;
		} else if (!währungskürzel.equals(other.währungskürzel))
			return false;
		if (währungsname == null) {
			if (other.währungsname != null)
				return false;
		} else if (!währungsname.equals(other.währungsname))
			return false;
		return true;
	}	
		
	
}
