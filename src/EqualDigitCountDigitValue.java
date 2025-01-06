public class EqualDigitCountDigitValue {
    public boolean digitCount(String num) {
        int[] vals = new int[10];
        for(int i = 0; i < num.length(); i++){
            vals[num.charAt(i) - '0']++;
        }
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) - '0' != vals[i]) {
                return false;
            }
        }
        return true;
    }
}
