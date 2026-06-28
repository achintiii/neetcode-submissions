class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++){
            cars[i] = new Car(position[i], speed[i], (double) (target - position[i])/speed[i]);
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(b.position, a.position));
        Stack<Car> stack = new Stack<>();
        stack.push(cars[0]);
        for (int i = 1; i < cars.length; i++){
            if (cars[i].time <= stack.peek().time){
               continue;
                
                
            }
            else {
                stack.push(cars[i]);
            }
            
        }
        return stack.size();
    }
    class Car {
        int position;
        int speed;
        double time;
        Car(int position, int speed, double time){
            this.position = position;
            this.speed = speed;
            this.time = time;
        }
    }

}
