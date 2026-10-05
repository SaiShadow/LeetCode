class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> score = new Stack<>();
        score.push(0);

        for(char c : s.toCharArray()) {
            if (c == '(') {
                score.push(0);
            } else {
                int top = score.pop();
                int currSum = score.pop();
                if(top == 0) {
                    score.push(1 + currSum);
                } else {
                    score.push(2 * top + currSum);
                }
            }
        }
        return score.pop();
    }
}