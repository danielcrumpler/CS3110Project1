package edu.westga.cs3110.unicoder.model;

/**
 * Stores Codepoint value and converts to different UTF encodings.
 * 
 * @author Daniel Crumpler
 * @version Fall 2020
 */
public class Codepoint {
	
	private String codepoint;
	
	/**
	 * Creates a new Codepoint.
	 * 
	 * @precondition 
	 * @postcondition getHexadecimal() == hexadecimal
	 * 
	 * @param codepoint the input codepoint string.
	 */
	public Codepoint(String codepoint) {
		if (!codepoint.matches("0*([0-7]{1}[0-9A-F]{7})|([0-9A-F]{1,7})")) {
			throw new IllegalArgumentException("hexadecimal needs to match.");
		}
		this.setHexadecimal(codepoint);
	}
	
	/**
	 * Gets the Codepoint String
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the codepoint
	 */
	public String getCodepoint() {
		return this.codepoint;
	}
	
	/**
	 * Sets the value of the current codepoint to a new codepoint value
	 * 
	 * @precondition
	 * @postcondition
	 * 
	 * @param codepoint the input codepoint string.
	 */
	public void setHexadecimal(String codepoint) {
		this.codepoint = codepoint;
	}

	/**
	 * Converts the Codepoint to UTF-32 Encoding.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoded Hexadecimal String as UTF-32
	 */
	public String toUTF32() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		return String.format("%08X", parsed);
	}
	
	/**
	 * Converts the Codepoint to UTF-16 Encoding.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoded Hexadecimal String as UTF-16
	 */
	public String toUTF16() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		if (parsed < 0x10000) {
			return this.isTwoBytesOfUTF16(parsed);
		} else {
			parsed -= 0x10000;
			int highSurrogate = 0xD800 + (parsed >> 10);
			int lowSurrogate = 0xDC00 + (parsed & 0b00000000001111111111);
			return String.format("%04X", highSurrogate) + String.format("%04X", lowSurrogate);
		}
	}

	private String isTwoBytesOfUTF16(int parsed) {
		if (parsed > 0xD7FF && parsed < 0xE000) {
			return null;
		} else {
			return String.format("%04X", parsed);
		}
	}
	
	/**
	 * Converts the Codepoint to UTF-8 Encoding.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return Encoded Hexadecimal String as UTF-8
	 */
	public String toUTF8() {
		int parsed = Integer.parseUnsignedInt(this.codepoint, 16);
		if (parsed < 0x80) {
			return String.format("%02X", parsed);
		} else if (parsed > 0x007F && parsed < 0x0800) {
			int upperByte = 0b11000000 + (parsed >> 6);
			int lowerByte = 0b10000000 + (parsed & 0b00000111111);
			return String.format("%04X", (upperByte << 8) + lowerByte);
		} else if (parsed > 0x07FF && parsed < 0x10000) {
			int byteOne = 0b11100100;
			int byteTwo = 0b10000000;
			int byteThree = 0b10000000;
			return String.format("%06X", );
		} else {
			return String.format("%08X", );
		}
		
	}
}
