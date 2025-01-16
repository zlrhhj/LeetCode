public class Fibonacci {
    public int fib(int n) {
        int[] fib = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            if(i <= 1) {
                fib[i] = i;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n];
    }
}
