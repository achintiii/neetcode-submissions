class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < cost.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumCost > sumGas){
            return -1;
        }
        int startIndex = 0;
        int netGain = 0;
        for (int i = 0; i < gas.length; i++){
            netGain += gas[i];
            netGain -= cost[i];
            if (netGain < 0){
                startIndex = i + 1;
                netGain = 0;
            }
        }
        if (netGain < 0){
            return -1;
        }
        return startIndex;
    }
}