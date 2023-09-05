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
     * @throws IllegalArgumentException If the input is invalid (null, empty, not a valid hexadecimal, or out of range).
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
     * Returns the UTF-8 encoding of the codepoint as either a 2-digit, 4-digit, 6-digit, or 8-digit hexadecimal string.
     *
     * @return The UTF-8 encoding as a 2-digit, 4-digit, 6-digit, or 8-digit hexadecimal string.
     */
    public String toUTF8() {
        StringBuilder utf8Encoding = new StringBuilder();
        if (this.codepoint <= 0x7F) {
            utf8Encoding.append(String.format("%02X", this.codepoint));
        } else if (this.codepoint <= 0x7FF) {
            this.twoByteEncoding(utf8Encoding);
        } else if (this.codepoint <= 0xFFFF) {
            this.threeByteEncoding(utf8Encoding);
        } else if (this.codepoint <= 0x10FFFF) {
            this.fourByteEncoder(utf8Encoding);
        }
        return utf8Encoding.toString();
    }

    private void fourByteEncoder(StringBuilder utf8Encoding) {
        utf8Encoding.append(String.format("%02X", 0xF0 | ((this.codepoint >> 18) & 0x07)));
        utf8Encoding.append(String.format("%02X", 0x80 | ((this.codepoint >> 12) & 0x3F)));
        utf8Encoding.append(String.format("%02X", 0x80 | ((this.codepoint >> 6) & 0x3F)));
        utf8Encoding.append(String.format("%02X", 0x80 | (this.codepoint & 0x3F)));
    }

	private void threeByteEncoding(StringBuilder utf8Encoding) {
		utf8Encoding.append(String.format("%02X", 0xE0 | ((this.codepoint >> 12) & 0x0F)));
		utf8Encoding.append(String.format("%02X", 0x80 | ((this.codepoint >> 6) & 0x3F)));
		utf8Encoding.append(String.format("%02X", 0x80 | (this.codepoint & 0x3F)));
	}

	private void twoByteEncoding(StringBuilder utf8Encoding) {
		utf8Encoding.append(String.format("%02X", 0xC0 | ((this.codepoint >> 6) & 0x1F)));
		utf8Encoding.append(String.format("%02X", 0x80 | (this.codepoint & 0x3F)));
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