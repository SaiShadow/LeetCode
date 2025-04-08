class Solution {
    public int minimumOperations(int[] nums) {
        int length = nums.length;

        boolean[] seen = new boolean[101];

        for (int i = length - 1; i >= 0; i--) {
            int n = nums[i];
            if(seen[n]){
                return i/3 + 1;
            }
            seen[n] = true;
        }
        return 0;
    }
}