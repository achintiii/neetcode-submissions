class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }
    public int houseRobber(int[] nums, int start, int end){
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[start + i], dp[i-1]);
        } 
        return dp[dp.length - 1];
    }
}
