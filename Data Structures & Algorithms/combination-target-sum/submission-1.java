class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0, curList, 0, target);
        return result;
        

    }
    public void backtrack(int[] nums, List<List<Integer>> result, int curIndex, List<Integer> curList, int curSum, int target){
        if (curSum == target){
            result.add(new ArrayList<>(curList));
            
        }
        if (curSum > target){
            return;
        }
        for (int i = curIndex; i < nums.length; i++){
            curList.add(nums[i]);
            backtrack(nums, result, i, curList, curSum + nums[i], target);
            curList.remove(curList.size() - 1);
            
        }
    }
}
