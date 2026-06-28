class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int num: nums){
            if (map.containsKey(num)){
                continue;
            }
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int chain = left + right + 1;
            if (chain > maxLen){
                maxLen = chain;
            }
            map.put(num, chain);
            //updating the boundaries
            map.put(num - left, chain);
            map.put(num + right, chain);
        }
        return maxLen;
    }
}
