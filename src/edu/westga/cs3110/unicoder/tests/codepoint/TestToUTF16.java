package edu.westga.cs3110.unicoder.tests.codepoint;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

/**
 * Tests for the Codepoint method toUTF16
 * 
 * @version Fall 2023
 * @author Craig Carriger
 */
public class TestToUTF16 {

    @Test
    public void testToUTF16() {
        Codepoint codepoint = new Codepoint("1F682");
        TestHelper.assertStringCaseInsensitiveEquals("1F682", codepoint.toUTF16());
    }
    
    @Test
    public void testToUTF16WithCodepointLessThanOrEqualTo0xFFFF() {
        Codepoint codepoint = new Codepoint("0041");
        TestHelper.assertStringCaseInsensitiveEquals("0041", codepoint.toUTF16());
    }

}
