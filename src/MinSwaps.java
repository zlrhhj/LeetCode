public class MinSwaps {
    public int minimumSwap(String s1, String s2) {
        int xy_count = 0;
        int yx_count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy_count++;
            } else if(s1.charAt(i) == 'y' && s2.charAt(i) =='x') {
                yx_count++;
            }
        }
        if((xy_count + yx_count) % 2 != 0){
            return -1;
        }
        return xy_count/2 + yx_count/2 + (xy_count % 2) * 2;
    }
}
