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
                int curSum = nums[left] + nums[right];
                if (curSum < target){
                    int index = left + 1;
                    while (index < right && nums[index] == nums[left]){
                        index ++;
                    }
                    left = index;
                }
                else if (curSum == target){
                    result.add(new ArrayList<>(List.of(nums[i], nums[left], nums[right])));
                    int index = right - 1;
                    while (index > left && nums[index] == nums[right]){
                        index --;
                    }
                    right = index;
                    index = left + 1;
                    while (index < right && nums[index] == nums[left]){
                        index ++;
                    }
                    left = index;
                }
                else {
                    int index = right - 1;
                    while (index > left && nums[index] == nums[right]){
                        index --;
                    }
                    right = index;
                }
            }
            
        }
        return result;
    }
}
