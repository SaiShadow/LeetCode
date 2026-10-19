class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> sol = new ArrayList<>(); 

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                sol.add(i);
            }
        }
        return sol;
    }
}