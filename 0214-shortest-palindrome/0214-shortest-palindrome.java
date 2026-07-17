class Solution {

    public String shortestPalindrome(String s) {

        if (s == null || s.length() <= 1)
            return s;

        String rev = new StringBuilder(s).reverse().toString();

        String temp = s + "#" + rev;

        int[] lps = buildLPS(temp);

        int longest = lps[lps.length - 1];

        String suffix = s.substring(longest);

        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] buildLPS(String str) {

        int[] lps = new int[str.length()];

        int len = 0;

        for (int i = 1; i < str.length();) {

            if (str.charAt(i) == str.charAt(len)) {

                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {

                    len = lps[len - 1];

                } else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}