class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // Choose first number
        for (int i = 1; i <= n / 2; i++) {

            // Leading zero check
            if (num.charAt(0) == '0' && i > 1)
                break;

            // Choose second number
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {

                // Leading zero check
                if (num.charAt(i) == '0' && j > 1)
                    break;

                if (isValid(num, 0, i, j))
                    return true;
            }
        }

        return false;
    }

    private boolean isValid(String num, int start, int len1, int len2) {

        long a = Long.parseLong(num.substring(start, start + len1));
        long b = Long.parseLong(num.substring(start + len1, start + len1 + len2));

        int index = start + len1 + len2;

        while (index < num.length()) {

            long sum = a + b;
            String s = String.valueOf(sum);

            if (!num.startsWith(s, index))
                return false;

            index += s.length();
            a = b;
            b = sum;
        }

        return true;
    }
}