class Solution {
    int have = 0;
    public String minWindow(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = tMap.size();
        int minLength = Integer.MAX_VALUE;
        int strStart = -1;
        int strEnd = -1;

        
        int left = 0;
        
        for(int right = 0; right < s.length(); right ++){
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            // if we have as many as we need, evaluate the length then shrink the window
            if (getHave(sMap, tMap) == tMap.size()){
                
                while (getHave(sMap, tMap) == tMap.size()){
                    if (right - left + 1 < minLength){
                        minLength = right - left + 1;
                        strStart = left;
                        strEnd = right;
                        
                    }
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1 );
                    left ++;

                
                    
                }
                while (getHave(sMap, tMap) == tMap.size()){
                        sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1 );
                        left ++;
                }
            }
        }
        if (strStart == -1 && strEnd == -1){
            return "";
        
        } 
        return s.substring(strStart, strEnd + 1);
    }
    public int getHave(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        have = 0;
        for (Character ch: tMap.keySet()){
            if (sMap.getOrDefault(ch, 0) >= tMap.get(ch)){
                have ++;
            }
        }
        return have;
    }

}
