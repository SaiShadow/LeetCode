class Solution {
    public boolean find132pattern(int[] nums) {        
 
        if (nums.length <= 2) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[nums.length - 1]);
        int three = Integer.MIN_VALUE;

        for (int i = nums.length - 2; i >= 0; i--) {
            int curr = nums[i];
            if (curr < three) {
                return true;
            }
            while (!stack.isEmpty() && curr > stack.peek()) {
                three = stack.pop();
            }
            stack.push(curr);
        }

        return false;
    }
}