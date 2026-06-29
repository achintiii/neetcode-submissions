class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum == target){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    newList.add(nums[i]);
                    result.add(newList);
                    left ++;
                    right --;
                    while (left < right && nums[left] == nums[left - 1]){
                        left ++;
                    }
                    while (right > left && nums[right] == nums[right + 1]){
                        right --;
                    }
                   

                }
                else if (sum < target){
                    left ++;
                }
                else {
                    right --;
                }
            }
            

            
        
        }
        return result;
    }
        
    
}
