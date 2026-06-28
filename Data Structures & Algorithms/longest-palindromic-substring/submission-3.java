class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 1;
        if (s.length() == 1){
            return s;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < isPalindrome.length; i++){
            for (int j = 0; j < isPalindrome.length; j++){
                if (i == j){
                    isPalindrome[i][j] = true;
                }
            }
        }
        for (int i = s.length() - 2; i >= 0; i--){
            for (int j = i + 1; j < isPalindrome.length; j++){
                if (s.charAt(i) == s.charAt(j) && (isPalindrome[i+1][j-1] || j-i <= 2)){
                    if (j - i + 1 > maxLength){
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                    isPalindrome[i][j] = true;
                }
            }
        }
        return s.substring(start, end + 1);
        




    }
}
