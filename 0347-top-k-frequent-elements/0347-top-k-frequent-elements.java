class Solution {
     public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.replace(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int[] key_arr = map.keySet().stream().mapToInt(Integer::intValue).toArray();

        if (map.keySet().size() == k) {
            return key_arr;
        }

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        Collections.reverse(values);
        values = values.subList(0, k);

        int size = 0;
        int[] sol = new int[k];
        boolean[] seen = new boolean[key_arr.length];

        for (int i : values) {
            for (int j = 0; j < key_arr.length; j++) {

                int key = key_arr[j];

                if (!seen[j] && map.get(key).equals(i)) {
                    sol[size] = key;
                    seen[j] = true;
                    size++;
                    break;
                }
            }

        }
        return sol;
    }
}