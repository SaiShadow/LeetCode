class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] result = new int[size * 2];

        for(int i = 0; i < size * 2; i++) {
            int j = i;
            if (i >= size) {
                j = i - size;
            }
            result[i] = nums[j];
        }
    return result;
    }
}