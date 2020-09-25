package edu.westga.cs3110.unicoder.model;

public class Codepoint {
	
	private String hexadecimal;
	
	/**
	 * Creates a new Codepoint.
	 * 
	 * @precondition 
	 * @postcondition getHexadecimal() == hexadecimal
	 * 
	 * @param hexadecimal
	 */
	public Codepoint(String hexadecimal) {
		this.setHexadecimal(hexadecimal);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHexadecimal() {
		return hexadecimal;
	}
	
	/**
	 * 
	 * @param hexadecimal
	 */
	public void setHexadecimal(String hexadecimal) {
		this.hexadecimal = hexadecimal;
	}

	/**
	 * 
	 * @return
	 */
	public String toUTF32() {
		int parsed = Integer.parseUnsignedInt(this.hexadecimal, 16);
		return String.format("%08X", parsed);
	}
	
	/**
	 * 
	 * @return
	 */
	public String toUTF16() {
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toUTF8() {
		return null;
	}
}
