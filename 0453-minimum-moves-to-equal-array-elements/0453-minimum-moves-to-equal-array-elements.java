class Solution {
    public int minMoves(int[] nums) {
        // incrementing n - 1 <=> decreasing 1 element. 
        // so decrese all elements to min

        int min = Arrays.stream(nums).min().getAsInt();
        int sum = 0;

        for(int n : nums) {
            sum += n - min;
        }

        return sum;
    }
}