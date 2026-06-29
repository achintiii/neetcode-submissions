class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int have = 0;
        int needCount = need.size();

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            if (need.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

                if (window.get(rightChar).equals(need.get(rightChar))) {
                    have++;
                }
            }

            while (have == needCount) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);

                    if (window.get(leftChar) < need.get(leftChar)) {
                        have--;
                    }
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
            ? ""
            : s.substring(minStart, minStart + minLength);
    }
}