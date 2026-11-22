class Solution {
    int[] recent;
    int[] finalParents;
    Map<Integer, List<Integer>> kids;
    int[] sol;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        finalParents = parent.clone();
        kids = new HashMap<>();
        recent = new int[26]; // stores the most recent occurence of the letter
        Arrays.fill(recent, -1);
        sol = new int[n];

        // O(n)
        populateKids(n, parent);

        // dfs while updating final
        dfs(0, s);

        kids = new HashMap<>();
        populateKids(n, finalParents);

        countChildren(0);
        return sol;
    }

    private void populateKids(int n, int[] parents) {
        for (int i = 1; i < n; i++) {
            int p = parents[i];
            kids.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
    }

    private int countChildren(int node) {
        var children = kids.getOrDefault(node, List.of());
        int count = children.size();
        for (int child : children) {
            count += countChildren(child);
        }
        sol[node] = count + 1;
        return count;
    }

    private void dfs(int node, String s) {
        int c = s.charAt(node) - 'a';

        int ancestor = recent[c];
        if (ancestor != -1) {
            finalParents[node] = ancestor;
        }

        int previous = recent[c];
        recent[c] = node;

        var children = kids.getOrDefault(node, List.of());
        for (int child : children) {
            dfs(child, s);
        }

        recent[c] = previous;
    }
}