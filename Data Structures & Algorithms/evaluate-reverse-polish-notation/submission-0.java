class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if (isInteger(tokens[i])){
                stack.push(tokens[i]);
                continue;
            }
            if (tokens[i].equals("+")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val1 + val2));
            }
            else if (tokens[i].equals("*")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val1 * val2));
            }
            else if (tokens[i].equals("-")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val2 - val1));
            }
            else if (tokens[i].equals("/")){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(val2 / val1));
            }
                

        }
        return Integer.parseInt(stack.pop());
    }
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
