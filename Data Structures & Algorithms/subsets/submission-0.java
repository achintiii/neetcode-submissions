class Solution {
    public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            backtrack(result, nums, 0, new ArrayList<>());
            return result;
    }
    public void backtrack(List<List<Integer>> result, int[] nums, int curIndex, List<Integer> curList){
        for (int i = curIndex; i < nums.length; i++){
            curList.add(nums[i]);
            result.add(new ArrayList<>(curList));
            backtrack(result, nums, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
}
