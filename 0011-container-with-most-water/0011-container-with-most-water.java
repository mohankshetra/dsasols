class Solution {
    public int maxArea(int[] height) {
        int maxProduct = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int distance = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int currentProduct = distance * minHeight;

            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
            }

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
            
     return maxProduct;    
    }
}
