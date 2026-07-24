class Solution {

    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        dfs(result, "", num, target, 0, 0, 0);

        return result;
    }

    private void dfs(List<String> result,
                     String path,
                     String num,
                     int target,
                     int index,
                     long value,
                     long prev) {

        if (index == num.length()) {

            if (value == target)
                result.add(path);

            return;
        }

        for (int i = index; i < num.length(); i++) {

            // No leading zeros
            if (i != index && num.charAt(index) == '0')
                break;

            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);

            if (index == 0) {

                dfs(result, currStr, num, target,
                        i + 1, curr, curr);

            } else {

                // Addition
                dfs(result,
                        path + "+" + currStr,
                        num,
                        target,
                        i + 1,
                        value + curr,
                        curr);

                // Subtraction
                dfs(result,
                        path + "-" + currStr,
                        num,
                        target,
                        i + 1,
                        value - curr,
                        -curr);

                // Multiplication
                dfs(result,
                        path + "*" + currStr,
                        num,
                        target,
                        i + 1,
                        value - prev + prev * curr,
                        prev * curr);
            }
        }
    }
}