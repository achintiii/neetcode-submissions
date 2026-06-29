class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++){
            int curNum = temperatures[i];
            while (!stack.isEmpty() && curNum > temperatures[stack.peek()]){
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
        
    }
}
