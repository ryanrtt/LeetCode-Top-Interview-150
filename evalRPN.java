/* LeetCode 150. Evaluate Reverse Polish Notation */

class Solution {
    public int evalRPN(String[] tokens) {
        // Stack for postfix evaluation
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            // If an operator, perform the operation
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int temp = stack.pop();
                switch (token) {
                    case "+" -> stack.push(stack.pop() + temp);
                    case "-" -> stack.push(stack.pop() - temp);
                    case "*" -> stack.push(stack.pop() * temp);
                    case "/" -> stack.push(stack.pop() / temp);
                }
            } else stack.push(Integer.valueOf(token)); // Otherwise, add the value to the stack
        }

        // Return final result
        return stack.pop();
    }
}