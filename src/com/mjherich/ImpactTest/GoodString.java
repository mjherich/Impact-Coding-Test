package com.mjherich.ImpactTest;

public class GoodString {
    private String goodStr = new String();

    /**
     * Takes in a string and strips away any consecutive, duplicate chars.
     * @param str
     */
    public GoodString(String str) {
        char[] chars = str.toCharArray();
        String lastChar = null;

        for (char c : chars) {
            String cStr = Character.toString(c);

            if (lastChar != null) {
                // Only build goodStr if we aren't on a consecutive duplicate
                if (!cStr.equals(lastChar)) {
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
