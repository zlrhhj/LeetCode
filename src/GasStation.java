public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;

        for(int i = 0; i < cost.length; i++ ) {
            totalCost += cost[i];
            totalGas += gas[i];
        }
        if(totalGas < totalCost) return -1;

        int remainGas = 0, start = 0;
        for(int i = 0; i < cost.length; i++) {
            remainGas += gas[i] - cost[i];
            if(remainGas < 0) {
                remainGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}
