class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] ugly = new int[n];
        ugly[0] = 1;

        int[] index = new int[k];

        for (int i = 1; i < n; i++) {

            long next = Long.MAX_VALUE;

            // Find next ugly number
            for (int j = 0; j < k; j++) {
                next = Math.min(next,
                        (long) primes[j] * ugly[index[j]]);
            }

            ugly[i] = (int) next;

            // Move every pointer that generated next
            for (int j = 0; j < k; j++) {
                if ((long) primes[j] * ugly[index[j]] == next) {
                    index[j]++;
                }
            }
        }

        return ugly[n - 1];
    }
}