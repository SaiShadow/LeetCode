class Solution {
    List<String> sol = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return sol;
    }

    void dfs(int n, int used, int open, String current) {
        if (open == 0 && n * 2 == current.length()) {
            sol.add(current);
            return;
        }
        if(used < n){
            dfs(n, used+1, open + 1, current + "("); 
        } 
        if(open > 0) {
            dfs(n, used, open -1, current + ")");
        }
    }
}