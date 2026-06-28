class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // top down
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;
        for (int i = dp.length - 2; i >= 0; i--){
            for (String word: wordDict){
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word) && dp[i + word.length()] == true){
                    dp[i] = true;
                }
            }
        }
        return dp[0];
        


    }
}
