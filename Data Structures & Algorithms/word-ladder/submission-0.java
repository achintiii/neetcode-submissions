class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        Map<String, List<String>> nei = new HashMap<>();
        wordList.add(beginWord);
        for (String word: wordList){
            for (int j = 0; j < word.length(); j++){
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        } 
        // now the regular bfs
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String currentWord = queue.remove();
                if (currentWord.equals(endWord)){
                    return res;
                }
                for (int j = 0; j < currentWord.length(); j++){
                    String pattern = currentWord.substring(0, j) + "*" + currentWord.substring(j + 1);
                    for (String neiWord: nei.getOrDefault(pattern, Collections.emptyList())){
                        if (!visited.contains(neiWord)){
                            visited.add(neiWord);
                            queue.add(neiWord);
                        }
                    }
                }
            }
            res ++;
        }
        return 0;
    }
}
