class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str: strs){
            result.append(String.valueOf(str.length()) + "#");
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++){
            int curIndex = i + 1;
            while (curIndex < str.length() && str.charAt(curIndex) != '#'){
                curIndex ++;
            }
            int length = Integer.parseInt(str.substring(i, curIndex));
            result.add(str.substring(curIndex + 1, curIndex + 1 + length));
            i = curIndex + length;

        }
        return result;
    }
}
