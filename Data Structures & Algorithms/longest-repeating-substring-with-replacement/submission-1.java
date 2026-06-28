class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maxFreq = Math.max(maxFreq, map.getOrDefault(s.charAt(i), 0));

            while ((i - left + 1) - maxFreq > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left ++;
            }
            maxFreq = findMaxFreq(map);
            result = Math.max(result, i - left + 1);

        }
        return result;

    }
    public int findMaxFreq(Map<Character, Integer> map){
        int maxFreq = 0;
        for (Character ch: map.keySet()){
            maxFreq = Math.max(maxFreq, map.get(ch));
        }
        return maxFreq;
    }
    
}
