import java.util.ArrayList;
import java.util.Arrays;

public class MaxUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a, b) -> b[1] - a[1]);
        int totalUnits = 0;
        for(int[] type : boxTypes) {
            if(truckSize > type[0]) {
                totalUnits += type[0] * type[1];
                truckSize -= type[0];
            } else {
                totalUnits += type[1] * truckSize;
                truckSize = 0;
                break;
            }
        }
        return totalUnits;
    }
}
