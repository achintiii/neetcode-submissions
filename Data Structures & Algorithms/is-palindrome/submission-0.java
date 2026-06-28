class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.length() == 0 || s.length() == 1){
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }
            String leftChar = s.substring(left, left + 1);
            String rightChar = s.substring(right, right + 1);
            if (!leftChar.equalsIgnoreCase(rightChar)){
                return false;
            }
            left ++;
            right --;
        }
        return true;

    }
}
