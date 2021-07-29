package Bankprojekt.Hummelbank.de.hsma.pr1.banking.domain;

import java.util.LinkedList;

public class Bank {
	private String name;
	private String land;
	private final String bic;
	private final int eigenkapital;
	private double kreditsumme = 0;

	// sp√§ter w√ºrden Sie das vermutlich mit einer HashMap implementieren
	// die Verwendung einer LinkedList statt eines Arrays erspart einen
	// Z√§hler f√ºr die Konten
	private final LinkedList<Bankkonto> kontenliste = new LinkedList<>();

	// ---------------------------------
	// Konstruktor + Getter
	// ---------------------------------

	public Bank(String name, String land, int eigenkapital, String bic) {
		super();
		this.name = name;
		this.land = land;
		this.eigenkapital = eigenkapital;
		this.bic = bic;
	}

	public String getName() {
		return name;
	}

	public String getLand() {
		return land;
	}

	public String getBic() {
		return bic;
	}

	// ---------------------------------
	// √∂ffentliche Schnittstelle
	// ---------------------------------

	public String kontoAnlegen(String inhaber, String w√§hrung) {
		// in der echten Welt, etwas wie: int limit = Schufa.ermittleKreditrahmen(inhaber);
		int limit = 1000;

		String ktonr = generiereKontoNummer();
		Bankkonto konto = new Bankkonto(ktonr,limit, inhaber, w√§hrung);
		kontenliste.add(konto);

		return konto.getKontonummer();
	}

	public String getW‰hrung(String ktoNr) {
		Bankkonto konto = findeKonto(ktoNr);
		return konto.getW√§hrung();
	}

	public void geldEinzahlen(String ktoNr, double betrag) {
		Bankkonto konto = findeKonto(ktoNr);
		konto.geldEinzahlen(betrag);
	}

	public double getKontostand(String ktoNr) {
		Bankkonto konto = findeKonto(ktoNr);
		return konto.getKontostand();
	}

	public void geldAuszahlen(String ktoNr, double betrag) {
		Bankkonto konto = findeKonto(ktoNr);

		if (!pr‰feKreditrahmen(konto, betrag)) {
			throw new RuntimeException("Kreditrahmen nicht ausreichend!");
		} else {
			double minusVorher = Math.min(konto.getKontostand(), 0);
			konto.geldAuszahlen(betrag);
			if (konto.getKontostand() < 0) {
				kreditsumme = kreditsumme + (konto.getKontostand() - minusVorher)*-1;
			}
			System.out.println(kreditsumme);
		}
	}

	public void geld¸berweisen(String ktoNrQ, String ktoNrZ, double betrag) {
		Bankkonto kontoQ = findeKonto(ktoNrQ);
		Bankkonto kontoZ = findeKonto(ktoNrZ);

		if (!pr‰feKreditrahmen(kontoQ, betrag)) {
			throw new RuntimeException("Kreditrahmen nicht ausreichend!");
		} else {
			kontoQ.geldAuszahlen(betrag);
			kontoZ.geldEinzahlen(betrag);
		}
	}

	// ---------------------------------
	// private Methoden
	// ---------------------------------

	private String generiereKontoNummer() {
		String kontenzahl = "" + (kontenliste.size() + 1);
		return "DE" + ("00000000" + kontenzahl).substring(kontenzahl.length());
	}

	private Bankkonto findeKonto(String ktoNr) {
		for (Bankkonto konto : kontenliste) {
			if (konto.getKontonummer().equals(ktoNr)) {
				return konto;
			}
		}

		throw new RuntimeException("Kontonummer nicht bekannt!");
	}

	// diese etwas "un-objektorientierte" Konstruktion ist nur wegen
	// der Eigenkapitalpr√ºfung der Bank erforderlich -> TODO!
	private boolean pr‰feKreditrahmen(Bankkonto konto, double betrag) {
		return (konto.getMaxAbhebung()) >= betrag && eigenkapital >= kreditsumme + betrag;
	}

}
