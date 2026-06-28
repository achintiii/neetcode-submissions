class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];
        prefixProduct[0] = 1;
        for (int i = 1; i < nums.length; i++){
            prefixProduct[i] = prefixProduct[i-1] * nums[i - 1];
        }
        postfixProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            postfixProduct[i] = postfixProduct[i + 1] * nums[i + 1];
        }
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++){
            output[i] = prefixProduct[i] * postfixProduct[i];
        }
        return output;
        

    }
}  
