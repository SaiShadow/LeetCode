class Solution {
    public String removeDuplicateLetters(String s) {

  Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        List<Character> list = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int i = 1; i < s.length(); i++) {

            char c = s.charAt(i);

            int size = stack.size();

            for (int j = 0; j < size; j++) {

                char p = stack.peek();
                
                if (stack.contains(c)) {
                    break;
                }

                if (p < c) {
                    if (!stack.contains(c)) {
                        stack.push(c);
                    }
                    break;
                } else if (p == c) {
                    break;

                } else {
                    if (list.contains(p)) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(c);
                            break;
                        }
                    } else {
                        if (!stack.contains(c)) {
                            stack.push(c);
                        }
                        break;
                    }
                }

            }

            list.remove(0);

        }

        String sol = "";
        int size = stack.size();

        for (int j = 0; j < size; j++) {

            sol = stack.pop() + sol;
            System.out.println(j + ": " + sol);
        }

        return sol;
    }
}