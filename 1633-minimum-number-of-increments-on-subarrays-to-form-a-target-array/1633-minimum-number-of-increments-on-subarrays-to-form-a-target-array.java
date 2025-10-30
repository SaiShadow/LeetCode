class Solution {
    public int minNumberOperations(int[] target) {

        int ops = 0;
        int prev = 0;

        for (int curr : target){
            if (curr > prev) {
                ops += curr - prev;
            }
            prev = curr;
        }
        return ops;
    }

}