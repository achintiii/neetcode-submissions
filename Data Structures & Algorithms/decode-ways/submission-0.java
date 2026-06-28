class Solution {
    public int numDecodings(String s) {
        int result = 0;
        int[] dp = new int[s.length() + 1]; // array where dp[i] represents the number of ways to decode after processing the first i  characters
        dp[0] = 1;
        if (s.charAt(0) != '0'){
            dp[1] = 1;
        }
        else {
            dp[1] = 0;
        }
        for (int i = 2; i < dp.length; i++){
            if (s.charAt(i - 1) != '0'){
                dp[i] += dp[i-1];
            }
            
            if (Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[dp.length - 1];
    }
}
