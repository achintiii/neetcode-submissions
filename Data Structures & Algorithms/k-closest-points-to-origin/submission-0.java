class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>((a,b) -> Double.compare(a.distance, b.distance));
        for (int[] point: points){
            minHeap.add(new Point(point[0], point[1]));
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++){
            Point point = minHeap.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;

    }
    class Point{
        int x;
        int y;
        double distance;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = x * x + y * y;
        }
    }
}
