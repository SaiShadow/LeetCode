class Solution {
    public int[] sortArrayByParity(int[] nums) {

        int length  = nums.length;
        int start = 0;
        int end = length - 1;
        int[] sol = new int[length];

        for(int i = 0; i < length; i++){
            int n = nums[i];
            if(nums[i] %2 == 0){
                //even
                sol[start++] = n;
            }else{
                //odd
                sol[end--] = n;
            }
        }
        return sol;
    }
}