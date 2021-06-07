package model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BilletesTest {
	
	

	
	@Test
	void testGetCantidad() {
		Billetes a = new Billetes();
		String n = "50000";
		assertEquals(a.getCantidad("50000"), n);
	}


	@Test
	void testEntregarBilletes() {
		Billetes a = new Billetes();
		int cantidad_50000 = a.getCantidad("50000"); //suponiendo que solo hay uno 
		assertEquals(a.entregarBilletes(50001),false);
	}	
}
