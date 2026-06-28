class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, candidates, target, new ArrayList<>(), 0, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, int[] candidates, int target, List<Integer> curList, int curSum, int curIndex){
        if (curSum > target){
            return;
        }
        if (curSum == target){
            result.add(new ArrayList<>(curList));
            return;
        }
        for (int i = curIndex; i < candidates.length; i++){
            if (i > curIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            curList.add(candidates[i]);
            backtrack(result, candidates, target, curList, curSum + candidates[i], i + 1);
            curList.remove(curList.size() - 1);
        }

    }
    
}
