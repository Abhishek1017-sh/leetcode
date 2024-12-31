class Solution {
    public int evalRPN(String[] tokens) {
        ArrayList<Integer> stack = new ArrayList<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                stack.add(a + b);
            } else if (token.equals("-")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                stack.add(a - b);
            } else if (token.equals("*")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                stack.add(a * b);
            } else if (token.equals("/")) {
                int b = stack.remove(stack.size() - 1);
                int a = stack.remove(stack.size() - 1);
                stack.add(a / b);
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.get(0);
    }
}