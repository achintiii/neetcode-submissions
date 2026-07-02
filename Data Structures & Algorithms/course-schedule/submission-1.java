class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<>());


        }
        for (int[] prereq: prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
            inDegree[prereq[0]] ++;
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
            for (int next: adjList.get(course)){
                inDegree[next] --;
                if (inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }
        return courses == numCourses;

    }
}
