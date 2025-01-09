import java.util.Arrays;

public class SortIntegersBy1Bits {
    public int[] sortByBits(int[] arr){
        int len = arr.length;
        int[][] bits = new int[len][2];
        for(int i = 0; i < len; i++) {
            bits[i][0] = Integer.bitCount(arr[i]);
            bits[i][1] = arr[i];
        }
        Arrays.sort(bits, (x,y) -> (x[0] == y[0] ? (x[1] - y[1]) : (x[0] - y[0])));
        for(int i = 0; i < len; i++) {
            arr[i] = bits[i][1];
        }
        return arr;
    }

}
