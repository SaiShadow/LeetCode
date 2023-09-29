class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer other = map.get(num);

            if (other != null) {
                return new int[] { i, other };

            } else {
                map.put(target - num, i);
            }
        }

        return null;
    }
}