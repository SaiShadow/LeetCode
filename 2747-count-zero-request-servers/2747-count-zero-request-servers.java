class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[1], k -> new HashSet<>()).add(log[0]);
        }

        int[][] indexedSortQuery = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            indexedSortQuery[i][0] = i;
            indexedSortQuery[i][1] = queries[i];
        }
        Arrays.sort(indexedSortQuery, (a, b) -> Integer.compare(a[1], b[1]));

        int[] sol = new int[queries.length];
        int[] count = new int[n + 1];
        int l = indexedSortQuery[0][1] - x;
        int r = l;
        int active = 0;
        for (int[] query : indexedSortQuery) {
            int index = query[0];
            int q = query[1];

            // extend right
            while (r <= q) {
                Set<Integer> servers = map.get(r);
                if (servers != null) {
                    for (int s : servers) {
                        int prev = count[s]++;
                        if (prev == 0) {
                            active++;
                        }
                    }
                }
                r++;
            }

            // retreat left
            while (l < q - x) {
                Set<Integer> servers = map.get(l);
                if (servers != null) {
                    for (int s : servers) {
                        int after = --count[s];
                        if (after == 0) {
                            active--;
                        }
                    }
                }
                l++;
            }
            sol[index] = n - active;
        }

        return sol;
    }
}