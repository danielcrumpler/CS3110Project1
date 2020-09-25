package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestCodepointSetCodepoint {

	@Test
	void testSet() {
		Codepoint codepoint = new Codepoint("1F682");
		codepoint.setCodepoint("ABCD");
		assertEquals("ABCD", codepoint.getCodepoint());
	}
	
	@Test
	void testInvalidSet() {
		Codepoint codepoint = new Codepoint("1F683");
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.setCodepoint("PLDS");
		});
	}
	
	@Test
	void testNullSet() {
		Codepoint codepoint = new Codepoint("1F684");
		assertThrows(NullPointerException.class, () -> {
			codepoint.setCodepoint(null);
		});
	}
	
	@Test
	void testEmptySet() {
		Codepoint codepoint = new Codepoint("1F685");
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.setCodepoint("");
		});
	}

}
