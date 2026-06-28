class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        return result;
    }
    public void generate(int n, int leftCount, int rightCount, StringBuilder curString, List<String> result){
        if (curString.length() == 2 * n){
            result.add(curString.toString());
            return;
        }
        if (leftCount > rightCount){
            curString.append(')');
            generate(n, leftCount, rightCount + 1, curString, result);
            curString.deleteCharAt(curString.length() - 1);
        }
        if (leftCount < n){
            curString.append('(');
            generate(n, leftCount + 1, rightCount, curString, result);
            curString.deleteCharAt(curString.length() - 1);
        }

    }
}
