/* LeetCode 150. Evaluate Reverse Polish Notation */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int temp = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(stack.pop() + temp);
                        break;
                    case "-":
                        stack.push(stack.pop() - temp);
                        break;
                    case "*":
                        stack.push(stack.pop() * temp);
                        break;
                    case "/":
                        stack.push(stack.pop() / temp);
                        break;
                }
            } else stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();
    }
}