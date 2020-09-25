package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestCodepointToUTF8 {

	@Test
	void testOneByte() {
		Codepoint codepoint = new Codepoint("15");
		assertEquals("15", codepoint.toUTF8());
	}
	
	@Test
	void testTwoByte() {
		Codepoint codepoint = new Codepoint("01A0");
		assertEquals("C6A0", codepoint.toUTF8());
	}
	
	@Test
	void testThreeByte() {
		Codepoint codepoint = new Codepoint("4CE3");
		assertEquals("E4B3A3", codepoint.toUTF8());
	}
	
	@Test
	void testFourByte() {
		Codepoint codepoint = new Codepoint("1AB341");
		assertEquals("F6AB8D81", codepoint.toUTF8());
	}

}
