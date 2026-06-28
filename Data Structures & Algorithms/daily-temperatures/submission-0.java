class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Element> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.push(new Element(0, temperatures[0]));
        for (int i = 1; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > stack.peek().value){
                Element element  = stack.pop();
                result[element.index] = i - element.index;
            }
            stack.push(new Element(i, temperatures[i]));
        }
        return result;
    }
    class Element{
        int index;
        int value;
        Element(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}
