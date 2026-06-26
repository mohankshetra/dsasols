class Solution {
    public int threeSumClosest(int[] nums, int target) {
                Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];  // Initialize with the first 3 numbers

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If this sum is closer to the target, update closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers
                if (currentSum < target) {
                    left++;  // Need a larger sum
                } else if (currentSum > target) {
                    right--; // Need a smaller sum
                } else {
                    // Exact match found
                    return currentSum;
                }
            }
        }

        return closestSum;

    }
}