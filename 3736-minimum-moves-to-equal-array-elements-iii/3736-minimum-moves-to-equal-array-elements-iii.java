class Solution {
    public int minMoves(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int moves = 0;
        for (int n : nums) {
            moves += max - n;
        }

        return moves;
    }
}