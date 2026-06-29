class Solution {
    public int trap(int[] height) {
       // amount of water trapped is the min of max from left and max from right - current height
       int[] maxFromLeft = new int[height.length];
       int[] maxFromRight = new int[height.length];
       maxFromLeft[0] = height[0];
       maxFromRight[height.length - 1] = height[height.length - 1];
       for (int i = 1; i < height.length; i++){
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], height[i]);
       }
       for (int i = height.length - 2; i >= 0; i--){
        maxFromRight[i] = Math.max(maxFromRight[i + 1], height[i]);
       }
       int water = 0;
       for (int i = 0; i < height.length; i++){
        if (height[i] < Math.min(maxFromLeft[i], maxFromRight[i])){
            water += (Math.min(maxFromLeft[i], maxFromRight[i]) - height[i]);
        }
       }
       return water;
    }
}
