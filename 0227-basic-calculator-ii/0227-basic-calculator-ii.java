import java.util.*;

class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (operator == '+') {
                    stack.push(number);
                }

                else if (operator == '-') {
                    stack.push(-number);
                }

                else if (operator == '*') {
                    stack.push(stack.pop() * number);
                }

                else if (operator == '/') {
                    stack.push(stack.pop() / number);
                }

                operator = ch;
                number = 0;
            }
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}