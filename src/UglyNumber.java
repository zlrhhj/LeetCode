import java.util.HashSet;
import java.util.Set;

public class UglyNumber {
    public boolean isUgly(int n) {
        if(n <= 0) return false;
        int[] factors = {2, 3, 5};
        for(int factor : factors) {
            n = keepDividingWhenDivisiable(n, factor);
        }
        return n == 1;
    }
    private int keepDividingWhenDivisiable(int dividend, int divisor) {
        while(dividend % divisor == 0) {
            dividend = dividend / divisor;
        }
        return dividend;
    }
}
