class Solution {
    public boolean isPalindrome(String s) {
        //s = s.strip();
        int start = 0;
        int end = s.length() - 1;
        while (start < end){
            if (!Character.isLetterOrDigit(s.charAt(start))){
                start ++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(end))){
                end --;
            }
            else {
                char st = Character.toLowerCase(s.charAt(start));
                char e = Character.toLowerCase(s.charAt(end));
                if (st != e){
                    return false;
                }
                start ++;
                end --;
            }

            
        }
        return true;
    }
}
