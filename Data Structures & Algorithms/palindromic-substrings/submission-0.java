class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1){
            return 1;
        }
        int count = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            isPalindrome[i][i] = true;
            count ++;
        }
        for (int i = s.length() - 2; i >= 0; i--){
            for (int j = i + 1; j < isPalindrome.length; j++){
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])){
                    count ++;
                    isPalindrome[i][j] = true;
                }
                
            }
        }
        return count;
    }
}
