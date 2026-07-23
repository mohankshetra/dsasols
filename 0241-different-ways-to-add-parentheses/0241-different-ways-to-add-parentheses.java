class Solution {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {

        if (memo.containsKey(expression))
            return memo.get(expression);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                List<Integer> left =
                        diffWaysToCompute(expression.substring(0, i));

                List<Integer> right =
                        diffWaysToCompute(expression.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {

                        if (ch == '+')
                            result.add(l + r);

                        else if (ch == '-')
                            result.add(l - r);

                        else
                            result.add(l * r);
                    }
                }
            }
        }

        // Base case: expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }
}