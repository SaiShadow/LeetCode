class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> x = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!open.empty()) {
                    open.pop();
                } else {
                    if (!x.empty()) {
                        x.pop();
                    } else {
                        return false;
                    }
                }
            } else if (c == '*') {
                x.push(i);
            } else {
                open.push(i);
            }
        }

        if (open.size() > x.size())
            return false;

        while (!open.empty()) {
            int openIndex = open.pop();
            int xIndex = x.pop();

            if (openIndex > xIndex)
                return false;
        }

        return true;
    }
}