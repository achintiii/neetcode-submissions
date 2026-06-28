    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            List<List<Integer>> bucket = new ArrayList<>();
            for (int i = 0; i < nums.length; i++){
                bucket.add(new ArrayList<>());
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int num: nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int key: map.keySet()){
                int count = map.get(key);
                bucket.get(count - 1).add(key);
            }
            int[] result = new int[k];
            int index = 0;
            for (int i = bucket.size() - 1; i >= 0 && index < k; i--){
                if (bucket.get(i).size() > 0){
                    for (int num: bucket.get(i)){
                        result[index] = num;
                        index ++;
                        if (index == k){
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
