class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstSplit = new HashMap<>(), secondSplit = new HashMap<>();
        int size = nums.size();

        for (int num : nums) {
            secondSplit.put(num, (secondSplit.getOrDefault(num, 0) + 1));
        }

        for(int i = 0; i<size; i++){

            int num = nums.get(i);

            firstSplit.put(num, (firstSplit.getOrDefault(num, 0) + 1));
            secondSplit.put(num, (secondSplit.get(num) - 1));

            if(
                firstSplit.get(num) * 2 > i + 1 &&
                secondSplit.get(num) * 2 > size - i - 1
            ){
                return i;
            }

        }
        return -1;
    }
}