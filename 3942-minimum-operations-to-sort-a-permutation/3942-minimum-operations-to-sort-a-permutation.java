class Solution {
    public int minOperations(int[] nums) {

        // is it sortable? -> Does an increasing or decreasing cycle exist? -> Only 1 descent / ascent allowed.
        int n = nums.length;
        int desc = 0;
        int descIndex = 0;
        int asc = 0;
        int ascIndex = 0;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return nums[0] < nums[1] ? 0 : 1;
        }

        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int prev;

            // check the edge case at border
            if (i == 0) {
                prev = nums[n - 1];
            } else {
                prev = nums[i - 1];
            }
            if (curr > prev) {
                asc++;
                ascIndex = i;
            } else {
                desc++;
                descIndex = i;
            }
        }

        // how many moves? 

        if (desc > 1 && asc > 1) {
            return -1;
        }

        if (asc > desc) {
            // most elements are ascending
            if (desc == 0) {
                // already sorted 
                return 0;
            }

            // where is the descent 

            if (descIndex <= (n / 2)) {
                return descIndex;
            } else {
                int sol = (n) - descIndex + 2;
                return Math.min(descIndex, sol);
            }

        } else {
            if (asc == 0) {
                return 1;
            }

            // where is the ascent
            if (ascIndex <= (n / 2)) {
                return ascIndex + 1;
            } else {
                int sol = (n - 1) - ascIndex + 2;
                return Math.min(ascIndex, sol);
            }
        }

    }
}