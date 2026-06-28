class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int maxSum = 0;
        for (int num: nums){
            maxSum += num;
        }
        int minSum = -maxSum;
        int offset = maxSum;
        int[][] dp = new int[nums.length + 1][2 * maxSum + 1];
        dp[0][offset] = 1;
        for (int i = 1; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                int curNum = nums[i - 1];
                if (j + curNum < dp[0].length){
                    dp[i][j] += dp[i-1][j + curNum];
                }
                if (j - curNum >= 0){
                    dp[i][j] += dp[i-1][j - curNum];
                }
            }
        }
        return (target + offset < 0 || target + offset >= dp[0].length) ? 0 
            : dp[nums.length][target + offset];
    }
}
