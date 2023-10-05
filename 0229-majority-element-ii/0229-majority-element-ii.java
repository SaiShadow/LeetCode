class Solution {

    public List<Integer> majorityElement(int[] nums) {

        int cond = nums.length / 3;

        List<Integer> sol = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {

            int value = map.getOrDefault(i, 0);

            if (value <= cond) {
                map.put(i, ++value);

                if (value > cond) {
                    sol.add(i);
                }

            }
        }
        return sol;
    }

}