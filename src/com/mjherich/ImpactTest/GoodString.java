package com.mjherich.ImpactTest;

/**
 * Mr. X's Good String Problem
 *
 * Takes in a string and strips away any consecutive, duplicate chars.
 * My first instinct when approaching this problem was to keep track of the
 * last character and only build up the "good string" if the last character
 * doesn't match the current character. Since the problem doesn't specify
 * what's allowed in modifying the input another solution would be to add
 */
public class GoodString {
    private String goodStr = new String();

    public GoodString(String str) {
        char[] chars = str.toCharArray();
        String lastChar = null;

        for (char c : chars) {
            String cStr = Character.toString(c);
            String cStrLower = cStr.toLowerCase();

            if (lastChar != null) {
                // Only build goodStr if we aren't on a consecutive duplicate
                if (!cStrLower.equals(lastChar.toLowerCase())) {
                    this.goodStr = this.goodStr + cStr;
                }
            } else {
                this.goodStr = this.goodStr + cStr;
            }
            lastChar = cStr;
        }
    }

    @Override
    public String toString() {
        return this.goodStr;
    }
}
