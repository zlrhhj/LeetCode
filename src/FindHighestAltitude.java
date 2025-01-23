public class FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int pre = 0;
        int max = 0;
        for(int i = 0; i < gain.length; i++) {
            pre = pre + gain[i];
            max = Math.max(pre, max);
        }
        return max;
    }
}
