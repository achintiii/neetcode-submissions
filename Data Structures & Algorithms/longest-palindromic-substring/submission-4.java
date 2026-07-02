class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int left = -1;
        int right = -1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp.length; j++){
                dp[i][j] = true;
            }
        }
        for (int i = dp.length - 1; i >= 0; i--){
            for (int j = 0; j < dp.length; j++){
                if (i > j){
                    continue;
                }
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1] ));
                if (dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    right = j;
                    left = i;

                }
            }
        }
        return s.substring(left, right + 1);
        
    }
}
