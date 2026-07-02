class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(houseRobber(nums, 0, nums.length - 2), houseRobber(nums, 1, nums.length - 1));
    }
    public int houseRobber(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }
        int[] dp = new int[right - left + 1];
        dp[0] = nums[left];
        dp[1] = Math.max(nums[left], nums[left + 1]);
        for (int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[left + i]);
        }
        return dp[dp.length - 1];
    }
}
