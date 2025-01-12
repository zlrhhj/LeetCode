public class MinSuffixFlips {
    public int minFlips(String target) {
        int flips = 0;
        for(int i = 0; i < target.length(); i++) {
            if(target.charAt(i) == '0') {
                flips += flips % 2;
            } else {
                flips += (flips % 2 == 0 ? 1 : 0);
            }
        }
        return flips;
    }
}
