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
	*/
    public Codepoint() {
    	this.codepoint = 0;
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