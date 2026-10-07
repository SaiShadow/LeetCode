class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        while (result.isEmpty() && !queue.isEmpty()) {
            // for each layer do:
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (isValid(curr)) {
                    result.add(curr);
                } else {
                    // generate the next level
                    for (int j = 0; j < curr.length(); j++) {
                        char c = curr.charAt(j);
                        if (c == '(' || c == ')') {
                            String next = curr.substring(0, j) + curr.substring(j + 1);
                            if (!visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open <= 0) {
                    return false;
                }
                open--;
            }
        }
        return open == 0;
    }
}