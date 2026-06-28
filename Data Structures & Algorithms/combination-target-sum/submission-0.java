class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, 0, new ArrayList<>(), 0, nums, target);
        return result;
    }
    public void backtrack(List<List<Integer>> result, int curSum, List<Integer> curList, int curIndex, int[] nums, int target){
        if (curSum > target){
            return;
        }
        if (curSum == target){
            result.add(new ArrayList<>(curList));
        }
        for (int i = curIndex; i < nums.length; i++){
            curList.add(nums[i]);
            backtrack(result, curSum + nums[i], curList, i, nums, target);
            curList.remove(curList.size() - 1);
        }

    }
}
