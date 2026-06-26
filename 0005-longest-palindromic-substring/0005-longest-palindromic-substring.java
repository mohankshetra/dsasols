class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Step 1: Transform the string (add '#' between characters and '^', '$' at ends)
        StringBuilder t = new StringBuilder("^");
        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }
        t.append("#$");
        char[] arr = t.toString().toCharArray();

        int[] p = new int[arr.length];  // Array to store palindrome radius at each center
        int center = 0, right = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            int mirror = 2 * center - i;

            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            // Expand around center i
            while (arr[i + (1 + p[i])] == arr[i - (1 + p[i])])
                p[i]++;

            // Update center and right boundary
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        // Step 2: Find the max length and center
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        // Step 3: Extract the original substring
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);

        }
    }
