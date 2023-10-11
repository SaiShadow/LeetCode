import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty() || (stack.peek() + 1 != c && stack.peek() + 2 != c)) {
                stack.push((int) c);
            } else {
                stack.pop();
            }
        }

        return stack.empty();
    }
}