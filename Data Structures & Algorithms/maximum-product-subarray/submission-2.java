class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            int tempMax = Math.max(Math.max(curMin * nums[i], curMax * nums[i]) , nums[i]);
            int tempMin = Math.min(Math.min(curMin * nums[i], curMax * nums[i]), nums[i]);
            curMax = tempMax;
            curMin = tempMin;
            result = Math.max(tempMax, result);
        }
        return result;
    }
}
