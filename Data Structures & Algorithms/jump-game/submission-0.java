class Solution {
    public boolean canJump(int[] nums) {
        int destination = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--){
            int maxJump = i + nums[i];
            if (maxJump >= destination){
                destination = i;
            }
        }
        return destination == 0;
        
    }
}
