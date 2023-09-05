package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** A helper class that provides unique functionality to ensure tests are able to check that values equal values
 * 
 * @author Craig Carriger
 * @version Fall 2023
 */
public class TestHelper {
	/**
	 * Static method that asserts that two Strings are equal to one another ignoring case sensitivity
	 * @param expected the expected value
	 * @param actual the actual resulting value
	 */
 public static void assertStringCaseInsensitiveEquals(String expected, String actual) {
     assertEquals(expected.toLowerCase(), actual.toLowerCase());
 }
}