class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean zeroExists = false;
        for(int num : arr) {
            if (num == 0) {
                zeroExists = true;
            }
        }
        if(!zeroExists){
            return false;
            }


        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int i,  boolean[] visited){
        if (i < 0 || i >= arr.length){
            return false;
        }
        // already visited
        if (visited[i]) {
            return false;
        }
        // success
        if (arr[i] == 0) {
            return true;
        }

        visited[i] = true;

        return dfs(arr, i - arr[i], visited)
            || dfs(arr, i + arr[i], visited);
    }
}