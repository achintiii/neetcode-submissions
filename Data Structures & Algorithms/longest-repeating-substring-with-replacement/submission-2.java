class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxCharFreq = 0;
        int result = 0;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++){
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            if (freqMap.get(s.charAt(right)) > maxCharFreq){
                maxCharFreq = freqMap.get(s.charAt(right));
            }
            while ((right - left + 1) - maxCharFreq > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left ++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
