class Solution {
    public int maxArea(int[] height) {

        int j = 0;
        int k = height.length - 1;
        int maxArea = 0;

        while (j < k) {

            int area = (k - j) * Math.min(height[j], height[k]);

            maxArea = area > maxArea ? area : maxArea;

            if (height[j] < height[k]) {
                j++;
            } else {
                k--;
            }
        }
        return maxArea;
    }
}