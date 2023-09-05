package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestConstructor {

	@Test
    public void testConstructorValid() {
        Codepoint codepoint = new Codepoint("1F682");
        TestHelper.assertStringCaseInsensitiveEquals("1F682", codepoint.toUTF16());
    }

    @Test
    public void testConstructorInvalidHex() {
        assertThrows(IllegalArgumentException.class, () -> new Codepoint("XYZ"));
    }

    @Test
    public void testConstructorOutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> new Codepoint("110000"));
    }

    @Test
    public void testConstructorEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new Codepoint(""));
    }

    @Test
    public void testConstructorNull() {
        assertThrows(IllegalArgumentException.class, () -> new Codepoint(null));
    }
}