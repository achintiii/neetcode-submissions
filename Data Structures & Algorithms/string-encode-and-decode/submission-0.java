class Solution {

    public String encode(List<String> strs) {
        String res = new String();
        for (String str: strs){
            int length = str.length();
            res += String.valueOf(length);
            res += "#";
            res += str;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String currentString = str;
        while (!currentString.isEmpty()){
            int index = currentString.indexOf('#');
            int length = Integer.parseInt(currentString.substring(0, index));
            result.add(currentString.substring(index + 1, index + 1 + length));
            currentString = currentString.substring(index + 1 + length);
        }
        return result;
    }
}
