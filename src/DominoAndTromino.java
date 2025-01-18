public class DominoAndTromino {
    public int numTilings(int n) {
        if(n <= 2) return n;
        long MOD = 1000000007;
        long[] full = new long[n + 1];
        long[] part = new long[n + 1];
        full[0] = 1;
        full[1] = 1;
        full[2] = 2;
        part[2] = 2;
        for(int i = 3; i <= n; i++) {
            full[i] = (full[i - 1] + full[i - 2] + part[i - 1]) % MOD;
            part[i] = (full[i - 2] * 2 + part[i - 1]) % MOD;
        }
        return (int)full[n];
    }
}
