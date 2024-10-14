class Solution {
        public long maxKelements(int[] nums, int k) {
                long sum = 0;

                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                for (int num : nums) {
                        maxHeap.add(num);
                }
                
                for (int i = 0; i < k; i++) {
                        int max = maxHeap.poll();
                        sum += max;
                        maxHeap.add(max % 3 == 0 ? max/3 : max/3+1);
                }
                
                return sum;
        }
}