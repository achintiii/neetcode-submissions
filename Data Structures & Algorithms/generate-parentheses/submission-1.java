class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String curString = new String();
        backtrack(n, result, curString, 0, 0);
        return result;

    }
    private void backtrack(int n, List<String> result, String curString, int leftCount, int rightCount){
        if (leftCount == n && rightCount == n){
            result.add(curString);
        
        }
        if (leftCount < n){
            
            backtrack(n, result, curString + "(", leftCount + 1, rightCount);
            

        }
        if (leftCount > rightCount){
            
            backtrack(n, result, curString + ")", leftCount, rightCount + 1);
            
        }
    }
}
