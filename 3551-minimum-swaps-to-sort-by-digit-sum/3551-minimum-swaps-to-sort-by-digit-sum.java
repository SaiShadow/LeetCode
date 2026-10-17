class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            int sumA = digitSum(a[0]);
            int sumB = digitSum(b[0]);

            if (sumA == sumB) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(sumA, sumB);
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || i == arr[i][1]) {
                continue;
            }

            int count = 0;
            int j = i;
            while (!visited[j]) {
                count++;
                visited[j] = true;
                j = arr[j][1];
            }

            swaps += count - 1;
        }

        return swaps;
    }

    private int digitSum(int n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}