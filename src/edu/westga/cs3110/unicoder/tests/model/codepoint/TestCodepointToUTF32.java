package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestCodepointToUTF32 {

	@Test
	void test() {
		Codepoint codepoint = new Codepoint("1F682");
		assertEquals("0001F682", codepoint.toUTF32());
	}

}
