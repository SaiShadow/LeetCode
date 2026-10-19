class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                return sol;
            }

            // forgo duplicates
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    sol.add(List.of(nums[i], nums[j], nums[k]));
                    j++;

                    // forgo duplicates
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sol;
    }
}