class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            int rem = 0 - nums[i];
            while (left < right){
                if (nums[left] + nums[right] == rem){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    result.add(newList);
                    while (left < right && nums[left] == nums[left + 1]){
                        left ++;
                    }
                    while (right > left && nums[right] == nums[right - 1]){
                        right --;
                    }
                    left ++;
                    right --;
                }
                else if (nums[left] + nums[right] < rem){
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
