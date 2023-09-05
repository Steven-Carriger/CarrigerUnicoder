package edu.westga.cs3110.unicoder.model;

/** An encoder to convert codepoints to UTF-8, UTF-16, and UTF-32 formats
 * 
 * @author Craig Carriger
 * @version Fall 2023
 */
public class Codepoint {

	private int codepoint;

    /**
	* Constructor for the codepoint object.
	* @param hexCodepoint the hexCodePoint to become a codepoint
	*/
    public Codepoint(String hexCodepoint) {
        if (hexCodepoint == null || hexCodepoint.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: hexCodepoint cannot be empty or null");
        }
        try {
            this.setCodepoint(Integer.parseUnsignedInt(hexCodepoint, 16));
            if (this.getCodepoint() < 0 || this.getCodepoint() > 0x10FFFF) {
                throw new IllegalArgumentException("Invalid codepoint: Out of range");
            }
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid input: hexCodepoint must be a valid hexadecimal string");
        }
    }
    
 /**
    * gets the current codepoint
    * @return the current codepoint
     */
	public int getCodepoint() {
		return this.codepoint;
	}

	/**
	 * sets the current codepoint
	 * @param codepoint the codepoint to be set to
	 */
	public void setCodepoint(int codepoint) {
		this.codepoint = codepoint;
	}
}