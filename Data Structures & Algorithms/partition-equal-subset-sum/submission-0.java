class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for (int i = 1; i < dp[0].length; i++){
            dp[0][i] = false;
        }
        for (int i = 1; i < nums.length + 1; i++){
            int curNum = nums[i-1];
            for (int j = 1; j < dp[0].length; j++){
                if (curNum > j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - curNum];
                }
            }
        }
        return dp[dp.length - 1][target];


    }
}
