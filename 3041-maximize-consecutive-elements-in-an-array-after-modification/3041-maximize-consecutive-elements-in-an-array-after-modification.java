class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 0;

        for (int n : nums) {
            // 2 choices, increase or keep the same
            dp.put(n + 1,
                    // if adding is bigger then take that otherwise keep the same
                    Math.max(
                            dp.getOrDefault(n, 0) + 1,
                            dp.getOrDefault(n + 1, 0)));

            dp.put(n,
                    Math.max(
                            dp.getOrDefault(n - 1, 0) + 1,
                            dp.getOrDefault(n, 0)));

            max = Math.max(max, Math.max(dp.get(n + 1), dp.get(n)));
        }
        return max;
    }
}