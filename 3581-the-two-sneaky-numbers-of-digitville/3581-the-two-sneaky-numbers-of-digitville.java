class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] allValues = new int[101];
        for (int num : nums) {
            allValues[num]++;
        }
        int index = 0;
        int[] result = new int[2];
        for (int i = 0; i < allValues.length; i++) {
            if (allValues[i] > 1) {
                result[index++] = i;
            }
        }
        return result;
    }
}