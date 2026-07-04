class Solution {

    public int minCut(String s) {

        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];
        int[] dp = new int[n];

        // Build palindrome table
        for (int end = 0; end < n; end++) {

            for (int start = 0; start <= end; start++) {

                if (s.charAt(start) == s.charAt(end) &&
                        (end - start <= 2 || palindrome[start + 1][end - 1])) {

                    palindrome[start][end] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {

            if (palindrome[0][i]) {

                dp[i] = 0;

            } else {

                dp[i] = i;

                for (int j = 1; j <= i; j++) {

                    if (palindrome[j][i]) {

                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
}