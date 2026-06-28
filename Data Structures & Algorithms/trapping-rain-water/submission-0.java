class Solution {
    public int trap(int[] height) {
        int[] maxFromLeft = new int[height.length];
        maxFromLeft[0] = height[0];
        for (int i = 1; i < height.length; i++){
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], height[i]);
        }
        int[] maxFromRight = new int[height.length];
        maxFromRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--){
            maxFromRight[i] = Math.max(height[i], maxFromRight[i + 1]);
        }
        int area = 0;
        for (int i = 0; i < height.length; i++){
            area += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }
        return area;
    }
}
