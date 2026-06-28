class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
       List<List<String>> result = new ArrayList<>(); 
       for (String str: strs){
        if (map.containsKey(sortedString(str))){
            map.get(sortedString(str)).add(str);
        }
        else {
            map.put(sortedString(str), new ArrayList<>());
            map.get(sortedString(str)).add(str);
        }
       }
       for (List<String> strings: map.values()){
        result.add(strings);
       }
       return result;
    }

    public String sortedString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
