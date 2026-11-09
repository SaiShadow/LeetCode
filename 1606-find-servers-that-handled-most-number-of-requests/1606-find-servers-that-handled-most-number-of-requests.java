class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        long[] freq = new long[k];
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        TreeSet<Integer> available = new TreeSet<>();

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {
            int arrivalTime = arrival[i];
            int duration = load[i];
            int wantedServer = i % k;

            releaseServers(arrivalTime, busy, available);

            int server = findSuitableServer(arrivalTime, available, wantedServer);
            if (server == -1) {
                continue;
            }
            freq[server]++;
            available.remove(server);
            busy.add(new long[]{server, arrivalTime + duration});
        }

        long maxLoad = Arrays.stream(freq).max().getAsLong();
        List<Integer> sol = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (freq[i] == maxLoad) {
                sol.add(i);
            }
        }
        return sol;
    }

    private void releaseServers(int arrivalTime, PriorityQueue<long[]> busy, TreeSet<Integer> available) {
        while (!busy.isEmpty() && busy.peek()[1] <= arrivalTime) {
            long[] s = busy.poll();
            available.add((int) s[0]);
        }
    }

    // If the (i % k)th server is available, assign the request to that server. Or +1 until the next one is available.
    private int findSuitableServer(int arrivalTime, TreeSet<Integer> available, int wantedServer) {
        if (available.isEmpty()) {
            return -1;
        }
        Integer server = available.ceiling(wantedServer);
        if (server == null) {
            return available.first();
        }
        return server;
    }
}