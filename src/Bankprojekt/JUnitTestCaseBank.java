package Bankprojekt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitTestCaseBank {
	
	@Test
	void testUmrechnenEuroInYen() {
		Waehrung euro = new Waehrung("euro", "EUR", 1.1808);
		assertEquals(132674.15, euro.umrechnen(1000, "yen"), 0.01);
		
	}
	
	@Test
	void testUmrechnenRubelInEuro() {
		Waehrung rubel = new Waehrung("rubel", "RUB", 0.0169);
		assertEquals(14.31, rubel.umrechnen(1000, "euro"), 0.01);
		
	}
	
	@Test
	void testToString() {
		Waehrung euro = new Waehrung("euro", "EUR", 1.1808);
		assertTrue(euro.toString().equals("euro [EUR]  = 1.1808 US-Dollar"));
	}
	
	@Test
	void testEquals() {
		Waehrung usdollar = new Waehrung("usdollar", "USD", 1.0000);
		Waehrung usdollar2 = new Waehrung("usdollar", "USD", 1.0000);
		assertTrue(usdollar2.equals(usdollar));
		
	}
	
	@Test
	void testVorkomma() {
		Betrag rechnungtotal = new Betrag(2415.15, "yen");
		assertEquals(2415, rechnungtotal.getVorkomma());
	}
	
	@Test
	void testVorkomma2() {
		Betrag rechnungtotal2 = new Betrag(241524115, "usdollar");
		assertEquals(241524115, rechnungtotal2.getVorkomma());
	}
	
	@Test
	void testNachkomma() {
		Betrag rechnung1 = new Betrag(2415.15, "euro");
		assertEquals(15, rechnung1.getNachkomma());
		
	}
	
	@Test
	void testNachkomma2() {
		Betrag rechnung2 = new Betrag(241524215, "euro");
		assertEquals(00, rechnung2.getNachkomma());
	}
	
	@Test
	void testgetVorzeichenPositiv() {
		Betrag positiv = new Betrag(241524215, "euro");
		assertEquals(1, positiv.getVorzeichen());
	}
	
	@Test
	void testgetVorzeichenNegativ() {
		Betrag negativ = new Betrag(-241524215, "euro");
		assertEquals(-1, negativ.getVorzeichen());
	}
	
	@Test
	void testmultiplizieren() {
		Betrag betragA = new Betrag(1500, "euro");
		long newbetragA = betragA.mutipliziere(betragA.Betrag, 50);
		assertEquals(75000, newbetragA);
	}
	
	@Test
	void testaddieren() {
		Betrag betragA = new Betrag(500, "euro");
		Betrag betragB = new Betrag(700, "euro");
		long newbetragA = betragA.addieren(betragA.Betrag, betragB.Betrag);
		assertEquals(120000, newbetragA);
	}
	
	@Test
	void testsubstrahieren() {
		Betrag betragA = new Betrag(-500, "euro");
		Betrag betragB = new Betrag(700, "euro");
		long newbetragA = betragA.substarhieren(betragA.Betrag, betragB.Betrag);
		assertEquals(-120000, newbetragA);
	}
	
	@Test
	void testgetAsDouble() {
		Betrag umwandeln = new Betrag(1234.5677,"euro");
		assertEquals(1234.56, umwandeln.getAsDouble());
	}
	
	@Test
	void testtoString() {
		Betrag rechnungstring = new Betrag(777.00, "euro");
		assertEquals("777,00 euro", rechnungstring.toString());
	}
	
	@Test
	void testprozent() {
		Betrag betragProzent = new Betrag(500, "euro");
		assertEquals(2500, betragProzent.prozent(betragProzent.Betrag, 5));
	}
	
	@Test
	void testpromille() {
		Betrag betragPromille = new Betrag(500, "euro");
		assertEquals(250, betragPromille.promille(betragPromille.Betrag, 5));
	}
	
	@Test
	void testtoString2() {
		Betrag rechnungstring2 = new Betrag(71255, "yen");
		assertEquals("71255,00 yen", rechnungstring2.toString());
	}
	
	@Test
	void testtoString3() {
		Betrag rechnungstring3 = new Betrag(-21.21, "rubel");
		assertEquals("-21,21 rubel", rechnungstring3.toString());
	}
	
	@Test
	void testEqualsBetrag() {
		Betrag euro = new Betrag(123456789, "euro");
		Betrag euro2 = new Betrag(123456789, "euro");
		assertTrue(euro2.equals(euro));
	}
	
	@Test
	void testSalodandGebühren() {
		Konto kontogebühren = new Konto("Rik Wachner", "euro", "EUR", 1.1808);
		Betrag b1 = new Betrag(-21.21, "euro");
		Betrag b2 = new Betrag(5621, "euro");
		Betrag b3 = new Betrag(1, "euro");
		kontogebühren.buche(b1); 
		kontogebühren.buche(b2);
		kontogebühren.buche(b3);
		assertEquals(5575.59, kontogebühren.gebuehren(kontogebühren.saldo(), 4.5), 0.1);
		
	}
	
	@Test
	void testBucheandSaldo() {
		Konto konto1 = new Konto("Rik Wachner", "euro", "EUR", 1.1808);
		Betrag b1 = new Betrag(-21.21, "euro");
		Betrag b2 = new Betrag(5621, "euro");
		Betrag b3 = new Betrag(1, "euro");
		konto1.buche(b1);
		konto1.buche(b2);
		konto1.buche(b3);
		assertEquals(560079, konto1.saldo());
	}
	
	@Test
	void testBucheandSaldo2() {
		Konto konto2 = new Konto("Rik Wachner", "euro", "EUR", 1.1808);
		Betrag b1 = new Betrag(-21.21, "yen");
		Betrag b2 = new Betrag(5621, "rubel");
		Betrag b3 = new Betrag(1, "usdollar");
		konto2.buche(b1);
		konto2.buche(b2);
		konto2.buche(b3);
		assertEquals(560100, konto2.saldo());
	}
	
	@Test
	void testBucheandSaldo3() {
		Konto konto3 = new Konto("Rikky Shane", "yen", "JPY", 0.0089);
		Betrag b1 = new Betrag(-21.21, "yen");
		Betrag b2 = new Betrag(5621, "rubel");
		Betrag b3 = new Betrag(1, "usdollar");
		konto3.buche(b1);
		konto3.buche(b2);
		konto3.buche(b3);
		assertEquals(560079, konto3.saldo());
	}

	@Test
	void Kontoauszug3() {
		Konto konto1 = new Konto("Rik Wachner", "euro", "EUR", 1.1808);
		Betrag b1 = new Betrag(-21.21, "yen");
		Betrag b2 = new Betrag(5621, "rubel");
		Betrag b3 = new Betrag(1, "usdollar");
		konto1.buche(b1);
		konto1.buche(b2);
		konto1.buche(b3);
		konto1.saldo();
		System.out.println(konto1.toString() + "\n");
		
	}
	
	@Test
	void testKontoauszug2() {
		Konto konto2 = new Konto("Rik Wachner", "euro", "EUR", 1.1808);
		Betrag b1 = new Betrag(-21.21, "euro");
		Betrag b2 = new Betrag(5621, "euro");
		Betrag b3 = new Betrag(1, "euro");
		konto2.buche(b1);
		konto2.buche(b2);
		konto2.buche(b3);
		konto2.saldo();
		System.out.println(konto2.toString() + "\n");
	}
	
	@Test
	void testKontoauszug3() {
		Konto konto3 = new Konto("Rikky Shane", "yen", "JPY", 0.0089);
		Betrag b1 = new Betrag(-21.21, "yen");
		Betrag b2 = new Betrag(5621, "rubel");
		Betrag b3 = new Betrag(1, "usdollar");
		konto3.buche(b1);
		konto3.buche(b2);
		konto3.buche(b3);
		konto3.saldo();
		System.out.println(konto3.toString());
	}
	
}
