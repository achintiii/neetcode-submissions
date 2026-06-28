class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = sortedString(s);
        String t1 = sortedString(t);
        return s1.equals(t1);
    }
    public String sortedString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
