class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        boolean down = false;
        boolean up = false;
        int countUp = 1;
        int countDown = 1;
        int curUp = 1;
        int curDown = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                down = true;
                if (up) {
                    up = false;
                    countUp = Math.max(curUp, countUp);
                    curUp = 1;
                }
                curDown++;
            } else if (nums[i] < nums[i + 1]) {
                up = true;
                if (down) {
                    down = false;
                    countDown = Math.max(curDown, countDown);
                    curDown = 1;
                }
                curUp++;
            } else {
                up = false;
                countUp = Math.max(curUp, countUp);
                curUp = 1;
                down = false;
                countDown = Math.max(curDown, countDown);
                curDown = 1;
            }
        }
        return Math.max(Math.max(countUp, curDown), Math.max(curUp, countDown));
    }

}