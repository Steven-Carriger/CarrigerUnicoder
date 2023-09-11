package edu.westga.cs3110.unicoder.tests.codepoint;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

/**
 * Tests for the Codepoint method toUTF32
 * 
 * @version Fall 2023
 * @author Craig Carriger
 */
public class TestToUTF32 {

    @Test
    public void testToUTF32() {
        Codepoint codepoint = new Codepoint("1F682");
        TestHelper.assertStringCaseInsensitiveEquals("0001F682", codepoint.toUTF32());
    }

}
