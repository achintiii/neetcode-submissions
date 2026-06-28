class Solution {
    public int lengthOfLIS(int[] nums) {
       int[] dp = new int[nums.length];
       dp[0] = 1;
       for (int i = 1; i < dp.length; i++){
        int maxLength = 1;
        for (int j = i - 1; j >= 0; j--){
            
            if (nums[i] > nums[j]){
                maxLength = Math.max(maxLength, dp[j] + 1);
            }
            
        }
        dp[i] = maxLength;
       }
       int result = 0;
       for (int num: dp){
        result = Math.max(result, num);
       }
       return result;
    }
}
