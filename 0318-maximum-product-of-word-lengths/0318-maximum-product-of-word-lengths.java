class Solution {
    public int maxProduct(String[] words) {

        int n = words.length;
        int[] mask = new int[n];

        // Build bitmask for each word
        for (int i = 0; i < n; i++) {
            int currMask = 0;

            for (char ch : words[i].toCharArray()) {
                currMask |= 1 << (ch - 'a');
            }

            mask[i] = currMask;
        }

        int ans = 0;

        // Compare every pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans,
                            words[i].length() * words[j].length());
                }
            }
        }

        return ans;
    }
}