class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] log : logs) {
            map.computeIfAbsent(log[1], k -> new HashSet<>()).add(log[0]);
        }

        int m = queries.length;
        int[] sol = new int[m];

        int[][] indexedSortQuery = new int[m][2];

        for (int i = 0; i < m; i++) {
            indexedSortQuery[i][0] = i;
            indexedSortQuery[i][1] = queries[i];
        }

        Arrays.sort(indexedSortQuery,
                (a, b) -> Integer.compare(a[1], b[1]));

        int[] count = new int[n + 1];
        int active = 0;

        int left = indexedSortQuery[0][1] - x;
        int right = left - 1;

        for (int[] query : indexedSortQuery) {
            int index = query[0];
            int q = query[1];

            // Expand right boundary
            while (right < q) {
                right++;

                Set<Integer> servers = map.get(right);

                if (servers != null) {
                    for (int server : servers) {
                        if (count[server]++ == 0) {
                            active++;
                        }
                    }
                }
            }

            // Shrink left boundary
            while (left < q - x) {
                Set<Integer> servers = map.get(left);

                if (servers != null) {
                    for (int server : servers) {
                        if (--count[server] == 0) {
                            active--;
                        }
                    }
                }

                left++;
            }

            sol[index] = n - active;
        }

        return sol;
    }
}