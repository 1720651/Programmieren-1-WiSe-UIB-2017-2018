package uebungen.beispiele;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import uebungen.aufgaben._Exercise13;

class JUnitTestQuersumme extends _Exercise13 {
		@Test
		void testquersumme(){
			assertTrue(quersumme(11111111)==8);
			assertTrue(quersumme(342)==9);
			assertTrue(quersumme(67139528609134109l)==74);
			
		}
		
}	
