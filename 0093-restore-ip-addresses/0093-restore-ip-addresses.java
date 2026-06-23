class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s,
                           int index,
                           List<String> path,
                           List<String> result) {

        // Found 4 segments
        if (path.size() == 4) {

            if (index == s.length()) {
                result.add(String.join(".", path));
            }

            return;
        }

        // Try segment lengths 1, 2, 3
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length())
                break;

            String segment =
                s.substring(index, index + len);

            if (!isValid(segment))
                continue;

            path.add(segment);

            backtrack(s,
                      index + len,
                      path,
                      result);

            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String segment) {

        // Leading zero
        if (segment.length() > 1 &&
            segment.charAt(0) == '0')
            return false;

        int value = Integer.parseInt(segment);

        return value >= 0 && value <= 255;
    }
}