package com.mjherich.ImpactTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodStringTest {

    @Test
    public void handlesDuplicateChars() {
        // Test case 1
        String str1 = "This is a test";
        GoodString goodStr1 = new GoodString(str1);
        assertEquals(str1, goodStr1.toString());

        // Test case 2
        String str2 = "This iss aaa test";
        GoodString goodStr2 = new GoodString(str2);
        assertEquals("This is a test", goodStr2.toString());

        // Test case 3
        String str3 = "This is a longerrrrrrrrrrrrrr testtt";
        GoodString goodStr3 = new GoodString(str3);
        assertEquals("This is a longer test", goodStr3.toString());
    }
}