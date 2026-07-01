class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] nums, int curIndex, List<List<Integer>> result, List<Integer> curList){
        result.add(new ArrayList<>(curList));
        for (int i = curIndex; i < nums.length; i++){
            curList.add(nums[i]);
            backtrack(nums, i + 1, result, curList);
            curList.remove(curList.size() - 1);
            
        }
    }
}
