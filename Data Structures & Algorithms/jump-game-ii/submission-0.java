class Solution {
    public int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;
        while (left < nums.length - 1 && right < nums.length - 1){
            int maxDistance = 0;
            for (int i = left; i <= right; i++){
                maxDistance = Math.max(maxDistance, nums[i] + i);
            }
            
            right = maxDistance;
            jumps ++;
        }
        return jumps;
    }
}
