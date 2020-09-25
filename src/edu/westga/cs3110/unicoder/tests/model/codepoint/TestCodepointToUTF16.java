package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestCodepointToUTF16 {

	@Test
	void testTwoByteInZoneOne() {
		Codepoint codepoint = new Codepoint("ABCD");
		assertEquals("ABCD", codepoint.toUTF16());
	}
	@Test
	void testTwoByteZoneOneMin() {
		Codepoint codepoint = new Codepoint("0000");
		assertEquals("0000", codepoint.toUTF16());
	}
	@Test
	void testTwoByteZoneOneMax() {
		Codepoint codepoint = new Codepoint("D7FF");
		assertEquals("D7FF", codepoint.toUTF16());
	}
	
	@Test
	void testTwoByteInZoneTwo() {
		Codepoint codepoint = new Codepoint("E00F");
		assertEquals("E00F", codepoint.toUTF16());
	}
	
	@Test
	void testTwoByteZoneTwoMin() {
		Codepoint codepoint = new Codepoint("E000");
		assertEquals("E000", codepoint.toUTF16());
	}
	
	@Test
	void testTwoByteZoneTwoMax() {
		Codepoint codepoint = new Codepoint("FFFF");
		assertEquals("FFFF", codepoint.toUTF16());
	}
	
	@Test
	void testFourByte() {
		Codepoint codepoint = new Codepoint("0183A5");
		assertEquals("D820DFA5", codepoint.toUTF16());
	}
	
	@Test
	void testGapByte() {
		Codepoint codepoint = new Codepoint("D8FF");
		assertEquals(null, codepoint.toUTF16());
	}

}
