class Solution {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int temp = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == (nums[i + 1])) {

                temp++;


            } else if (nums[i] + 1 < nums[i + 1]) {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }

        }
        return (max >= temp ? max : temp) + 1;
    }
}