class Solution {
    public boolean isValid(String s) {

        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char c : charArr) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if( stack.isEmpty()) return false; 
                char lastOpenedBracket = stack.pop();
                switch (lastOpenedBracket) {
                    case '(': 
                        if(c != ')') return false;
                        break;
                    case '[': 
                        if(c != ']') return false;
                        break;
                    case '{': 
                        if(c != '}') return false;
                        break;
                    default: 
                        return false;
                }
            }
        } 
        return stack.isEmpty();
    }
}
