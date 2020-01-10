class Solution {
    public boolean isValid(String s) {
        char[] strArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : strArr) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char tmp = stack.peek();
                if (
                    tmp == '(' && ch == ')' ||
                    tmp == '[' && ch == ']' ||
                    tmp == '{' && ch == '}'
                ) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}