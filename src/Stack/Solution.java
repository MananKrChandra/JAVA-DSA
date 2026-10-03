package Stack;

import java.util.Stack;

public class Solution {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int currentLength = i - stack.peek();
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = ")()())";

        int result = solution.longestValidParentheses(s);

        System.out.println("Input: " + s);
        System.out.println("Longest valid parentheses length: " + result);
    }
}