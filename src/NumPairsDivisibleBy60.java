public class NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] seen = new int[60];
        int count = 0;
        for(int t : time) {
            count += seen[(60 - t % 60) % 60];
            seen[t % 60]++;
        }
        return count;
    }
}
