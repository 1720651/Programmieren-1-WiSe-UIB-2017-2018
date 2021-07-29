package Bankprojekt.Hummelbank.de.hsma.pr1.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankkontoTest {

	@Test
	void testKontoÜberziehung() {
		Bankkonto konto = new Bankkonto("DE12345678", 100, "Kent Beck", "EUR");
		konto.geldEinzahlen(100);
		konto.geldAuszahlen(200);
		assertEquals(-100, konto.getKontostand(), 0.001);
	}

	@Test
	void testKontoTutNichts() {
		Bankkonto konto = new Bankkonto("DE12345678", 0, "Kent Beck", "EUR");
		konto.geldEinzahlen(0);
		konto.geldAuszahlen(0);
		assertEquals(0, konto.getKontostand(), 0.00001);
	}

	@Test
	void testKontoWiederLeer() {
		Bankkonto konto = new Bankkonto("DE12345678", 1000, "Kent Beck", "EUR");
		konto.geldEinzahlen(500000);
		konto.geldAuszahlen(100000);
		konto.geldAuszahlen(200000);
		konto.geldAuszahlen(200000);
		assertEquals(0, konto.getKontostand(), 0.00001);
	}

	@Test
	void testKontoLimit() {
		Bankkonto konto = new Bankkonto("DE12345678", 1000, "Kent Beck", "EUR");
		konto.geldAuszahlen(500);
		konto.geldAuszahlen(500);
		assertEquals(-1000, konto.getKontostand(), 0.00001);

		try {
			konto.geldAuszahlen(200000);
			fail("Exception erwartet!");
		} catch(RuntimeException e) {
			// in Production Code niemals leer lassen!
		}
	}
}
