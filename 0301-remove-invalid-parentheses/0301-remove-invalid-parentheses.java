import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String cur = queue.poll();

            if (isValid(cur)) {
                ans.add(cur);
                found = true;
            }

            if (found)
                continue;

            for (int i = 0; i < cur.length(); i++) {

                char ch = cur.charAt(i);

                if (ch != '(' && ch != ')')
                    continue;

                String next =
                        cur.substring(0, i) +
                        cur.substring(i + 1);

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(')
                balance++;

            else if (c == ')') {

                if (balance == 0)
                    return false;

                balance--;
            }
        }

        return balance == 0;
    }
}