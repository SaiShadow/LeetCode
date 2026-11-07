class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] sol = new int[tasks.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(servers[a], servers[b]);
            return cmp == 0 ? Integer.compare(a, b) : cmp;
        });
        for (int i = 0; i < servers.length; i++) {
            pq.add(i);
        }
        // maps the tasks that can get free at this time. time -> tasks
        TreeMap<Long, Set<Integer>> busy = new TreeMap<>();
        long time = 0;
        int taskQueue = 0;

        while (taskQueue < tasks.length) {
            // release all servers that complete at this time
            boolean released = release(busy, pq, time);

            if(pq.isEmpty()) {
                time = busy.firstKey();
                continue;
            }

            while (!pq.isEmpty() && taskQueue <= time && taskQueue < tasks.length) {
                int task = tasks[taskQueue];
                int server = pq.poll();
                sol[taskQueue] = server;
                busy.computeIfAbsent(task + time, k -> new HashSet<Integer>()).add(server);
                taskQueue++;
            }
            time++;
        }

        return sol;
    }

    private boolean release(Map<Long, Set<Integer>> busy, PriorityQueue<Integer> pq, long time) {
        for (int s : busy.getOrDefault(time, Set.of())) {
            pq.add(s);
        }

        return busy.remove(time) != null;
    }
}