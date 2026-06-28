class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // dp[i][j] represents the number of distinct subsequences 
        // you can form from the first i characters of s and the first j characters of t
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i - 1) == t.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    
    }
}
