class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());

        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite: prerequisites){
            inDegree[prerequisite[0]] ++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int courses = 0;
        for (int i = 0; i < inDegree.length; i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int course = queue.remove();
            courses ++;
            for (int i = 0; i < adjList.get(course).size(); i++){
                inDegree[adjList.get(course).get(i)] --;
                if (inDegree[adjList.get(course).get(i)] == 0){
                    queue.add(adjList.get(course).get(i));
                }
            }
        }
        return courses == numCourses;

    }
}
