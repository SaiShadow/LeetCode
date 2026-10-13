class Solution {
    public long maxAlternatingSum(int[] nums) {

        long[] nSquare = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            nSquare[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(nSquare);
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                sum -= nSquare[i];
            } else {
                sum += nSquare[i];
            }
        }
        return sum;
    }
}