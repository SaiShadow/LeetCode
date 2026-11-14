class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        long answer = 0, cost = 0;
        int n = nums.length;

        // (value, count)
        Deque<int[]> dq = new ArrayDeque<>();

        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            // new value enters
            int value = nums[l];
            int count = 1;

            // check if cost has to be updated if value is bigger than current
            while(!dq.isEmpty() && value >= dq.getFirst()[0]) {
                int[] first = dq.removeFirst();
                // either the same value or lower -> increase cost and count accordingly
                count += first[1];
                cost += (long) (value - first[0]) * first[1];
            }

            dq.addFirst(new int[]{value, count});

            while(cost > k) {
                // remove elements from the right -> r--
                int[] last = dq.removeLast();
                cost -= last[0] - nums[r];
                if(last[1] > 1) {
                    dq.addLast(new int[]{last[0], last[1] - 1});
                }
                r--;
            }
            // valid so count the subarrays in this area
            answer += r - l + 1;
        }
        return answer;
    }
}