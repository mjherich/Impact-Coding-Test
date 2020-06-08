package com.mjherich.ImpactTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteStringTest {

    @Test
    public void isCompleteString() {
        // Test 1
        String str1 = "abcdefgHijklmnopqrstUVWxyz";
        Boolean isCompleteStr1 = CompleteString.check(str1);
        assertEquals(true, isCompleteStr1);

        // Test 2
        String str2 = "this is definitely not a complete string!";
        Boolean isCompleteStr2 = CompleteString.check(str2);
        assertEquals(false, isCompleteStr2);

        // Test 3
        String str3 = "Xylophone, lazy, cat, lake, desert, wind, fire, quiz, band, van, jet, game";
        Boolean isCompleteStr3 = CompleteString.check(str3);
        assertEquals(true, isCompleteStr3);

        // Test 4
        String str4 = "it ignores special characters like !@#$%^&*()-_=+':;,<.>/?";
        Boolean isCompleteStr4 = CompleteString.check(str4);
        assertEquals(false, isCompleteStr4);

    }

}