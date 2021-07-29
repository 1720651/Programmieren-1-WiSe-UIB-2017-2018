package Bankprojekt;

public class Waehrung {
	private final String w�hrungsname;
	private final String w�hrungsk�rzel;
	private final double wechselkursown;
	
	public Waehrung(String w�hrungsname, String w�hrungsk�rzel, double wechselkursown) {
		this.w�hrungsname = w�hrungsname;
		this.w�hrungsk�rzel = w�hrungsk�rzel;
		this.wechselkursown = wechselkursown;

	}

	public String getW�hrungsname() {
		return w�hrungsname;
	}

	public String getW�hrungsk�rzel() {
		return w�hrungsk�rzel;
	}
	
	public double getWechselkursown() {
		return wechselkursown;
	}

	
	double umrechnen(double Betrag, String wechselW�hrung) {
		
		switch(wechselW�hrung) {
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
		return (w�hrungsname + " [" + w�hrungsk�rzel + "] " + " = " + wechselkursown + " US-Dollar");	
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
		if (w�hrungsk�rzel == null) {
			if (other.w�hrungsk�rzel != null)
				return false;
		} else if (!w�hrungsk�rzel.equals(other.w�hrungsk�rzel))
			return false;
		if (w�hrungsname == null) {
			if (other.w�hrungsname != null)
				return false;
		} else if (!w�hrungsname.equals(other.w�hrungsname))
			return false;
		return true;
	}	
		
	
}
