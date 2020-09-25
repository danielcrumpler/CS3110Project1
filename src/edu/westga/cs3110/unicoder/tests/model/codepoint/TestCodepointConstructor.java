package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestCodepointConstructor {

	@Test
	void testInvalidConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("PLDLS");
		});
	}
	
	@Test
	void testNullConstructor() {
		assertThrows(NullPointerException.class, () -> {
			new Codepoint(null);
		});
	}
	
	@Test
	void testEmptyConstructor() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("");
		});
	}

}
