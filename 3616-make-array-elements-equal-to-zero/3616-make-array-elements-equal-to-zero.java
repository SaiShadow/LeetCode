class Solution {
    public int countValidSelections(int[] nums) {

        int valid = 0;
        int numOfNotZero = 0;

        for (int curr : nums) 
            if (curr != 0)
                numOfNotZero++;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                valid += process(nums.clone(), i, numOfNotZero, 1);
                valid += process(nums.clone(), i, numOfNotZero, -1);
            }
        }
        return valid;
    }

    private int process(int[] nums, int curr, int numOfNotZero, int direction) {

        while (numOfNotZero != 0 && curr >= 0 && curr < nums.length) {
            int val = nums[curr];
            if(val != 0){
                nums[curr] = --val;
                direction *= -1;
                if(val == 0)
                    numOfNotZero--;
            }
            curr += direction;
        } 
        return numOfNotZero == 0 ? 1 : 0;
    }
}