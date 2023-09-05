package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF8 {

	@Test
    public void testToUTF8SingleByte() {
        Codepoint codepoint = new Codepoint("0024");
        assertEquals("24", codepoint.toUTF8().toUpperCase());
    }

    @Test
    public void testToUTF8TwoBytes() {
        Codepoint codepoint = new Codepoint("00A2");
        assertEquals("C2A2", codepoint.toUTF8().toUpperCase());
    }

    @Test
    public void testToUTF8ThreeBytes() {
        Codepoint codepoint = new Codepoint("20AC");
        assertEquals("E282AC", codepoint.toUTF8().toUpperCase());
    }

    @Test
    public void testToUTF8FourBytes() {
        Codepoint codepoint = new Codepoint("1F600");
        assertEquals("F09F9880", codepoint.toUTF8().toUpperCase());
    }

}
