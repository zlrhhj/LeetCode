import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        while(n != 1 && !set.contains(n)){
            set.add(n);
            sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n/10;
            }
            n = sum;
        }
        return  n == 1 ? true:false;
    }
}
