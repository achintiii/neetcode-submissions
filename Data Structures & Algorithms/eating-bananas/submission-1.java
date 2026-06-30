class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (can(piles, mid, h)){
                // have to go left
                right = mid - 1;
                result = Math.min(result, mid);
            }
            else {
                left = mid + 1;
            }
        }
        return result;

    }
    public boolean can(int[] piles, int k, int h){
        double hours = 0;
        for (int pile: piles){
            hours += Math.ceil((double) pile / k);
        }
        return hours <= h;
    }
}
