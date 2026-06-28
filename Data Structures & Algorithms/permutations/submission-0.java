class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>());
        return result;
    }
    public void backtrack(List<List<Integer>> result, int[] nums, List<Integer> curList){
        if (curList.size() == nums.length){
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!curList.contains(nums[i])){
                curList.add(nums[i]);
                backtrack(result, nums, curList);
                curList.remove(curList.size() - 1);
            }
        }


    }
}
