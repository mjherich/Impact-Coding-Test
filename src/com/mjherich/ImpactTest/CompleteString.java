package com.mjherich.ImpactTest;

import java.util.HashMap;

public class CompleteString {

    public static Boolean check(String str) {
        // Create hashmap
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        // Assume case insensitive, so convert string to lower
        str = str.toLowerCase();

        // Loop over each character in the input string
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int charCode = (int) c;

            // Skip adding the character to the hashmap if it's not between a-z
            if ((charCode < 97) || (charCode > 122)) {
                continue;
            }

            if (hm.containsKey(c)) {
                int count = hm.get(c);
                hm.put(c, count + 1);
            } else {
                hm.put(c,1);
            }
        }

        // If the hashmap has 26 keys the string is complete
        if (hm.keySet().size() == 26) {
            return true;
        } else {
            return false;
        }
    }
}
