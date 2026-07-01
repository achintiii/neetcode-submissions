class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> heap = new PriorityQueue<>((a,b) -> Double.compare(a.distance, b.distance));
        int[][] result = new int[k][2];
        for (int[] point: points){

            heap.add(new Point(point[0], point[1]));
        }
        for (int i = 0; i < k; i++){
            Point point = heap.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;

    }
    class Point {
        int x;
        int y;
        double distance;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.distance = Math.pow(x, 2) + Math.pow(y, 2);
        }
    }
}
