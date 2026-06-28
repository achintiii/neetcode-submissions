class Solution {
    public String foreignDictionary(String[] words) {
        if (words.length == 1) return words[0];

        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Add all characters to graph
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Build graph edges
        for (int i = 1; i < words.length; i++) {
            int improperIndex = findIndex(words[i - 1], words[i]);
            if (improperIndex == -1) {
                if (words[i - 1].length() > words[i].length()) {
                    return ""; // invalid case
                }
            } else {
                char c1 = words[i - 1].charAt(improperIndex);
                char c2 = words[i].charAt(improperIndex);
                if (graph.get(c1).add(c2)) {
                    inDegree.put(c2, inDegree.get(c2) + 1);
                }
            }
        }

        // Topological sort
        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.remove();
            result.append(ch);
            for (char neighbor : graph.get(ch)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result.length() == graph.size() ? result.toString() : "";
    }

    public int findIndex(String word1, String word2) {
        int index = 0;
        while (index < word1.length() && index < word2.length()) {
            if (word1.charAt(index) != word2.charAt(index)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}