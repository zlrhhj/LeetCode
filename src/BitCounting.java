public class BitCounting {
    public int[] countBits(int n) {
        int[] results = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            results[i] = results[i / 2];
            if( i % 2 == 1) {
                results[i]++;
            }
        }
        return results;
    }
}
