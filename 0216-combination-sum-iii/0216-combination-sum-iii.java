class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        backtrack(1, k, n, new ArrayList<>());

        return result;
    }

    private void backtrack(int start, int k, int target, List<Integer> path) {

        // Valid combination
        if (target == 0 && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Invalid state
        if (target < 0 || path.size() > k)
            return;

        for (int i = start; i <= 9; i++) {

            path.add(i);

            backtrack(i + 1, k, target - i, path);

            path.remove(path.size() - 1);
        }
    }
}