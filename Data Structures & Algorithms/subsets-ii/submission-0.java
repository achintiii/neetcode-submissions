class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;

    }
    public void backtrack(List<List<Integer>> result, int[] nums, int curIndex, List<Integer> curList){
        result.add(new ArrayList<>(curList));
        for (int i = curIndex; i < nums.length; i++){
            if (i != curIndex && nums[i] == nums[i - 1]){
                continue;
            }
            curList.add(nums[i]);
            backtrack(result, nums, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
