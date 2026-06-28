class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNum = 0;
        for (int num: piles){
            maxNum = Math.max(num, maxNum);
        }
        int left = 1;
        int right = maxNum;
        int answer = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (simulate(piles, mid, h)){
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return answer;
    }
    public boolean simulate(int[] piles, int k, int h){
        int hours = 0;
        for (int pile: piles){
            hours += Math.ceil(pile / (double) k);
        }
        return hours <= h;
    }

}
