class Solution {
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for (int i = 0; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            String letters = KEYPAD[digit];
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                String combination = queue.poll();
                for (char c : letters.toCharArray()) {
                    queue.add(combination + c);
                }
            }
        }

        result.addAll(queue);
        return result;
    }


}