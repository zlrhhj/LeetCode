public class DecodeWays {
    private int count;

    public int numDecodings(String s) {
        count = 0;
        backTrack(s, 0);
        return count;
    }
    private void backTrack(String s, int index) {
        if(index == s.length()) {
            count++;
            return;
        }
        if(s.charAt(index) == '0') {
            return;
        }
        backTrack(s, index + 1);
        if(index < s.length() - 1) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if(num <= 26) {
                backTrack(s, index + 2);
            }
        }
    }
}
