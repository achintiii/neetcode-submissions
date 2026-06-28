class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++){
            if (checkPermutation(s1, s2.substring(i, i + s1.length()))){
                return true;
            }
        }
        return false;
        
    }
    public boolean checkPermutation(String s1, String s2){
        // checks if s2 is a permutation of s1
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String string1 = new String(c1);
        String string2 = new String(c2);
        return string1.equals(string2);
    }
}
