class Solution {
    public boolean isNumber(String s) {
         boolean digitSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digitSeen = true;
            }
            else if (ch == '+' || ch == '-') {
                // Sign must be first character
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (ch == '.') {
                // Dot cannot appear after exponent
                // and only one dot allowed
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }
            else if (ch == 'e' || ch == 'E') {
                // Only one exponent allowed
                // Must have digits before exponent
                if (eSeen || !digitSeen) {
                    return false;
                }

                eSeen = true;

                // Need digits after exponent
                digitSeen = false;
            }
            else {
                return false;
            }
        }

        return digitSeen;
        
    }
}