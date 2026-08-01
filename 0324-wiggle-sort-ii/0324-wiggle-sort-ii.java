import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int[] arr = nums.clone();
        Arrays.sort(arr);

        // End of smaller half
        int left = (n - 1) / 2;

        // End of larger half
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = arr[left--];
            } else {
                nums[i] = arr[right--];
            }
        }
    }
}