public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len < 2) {
            return "";
        }

        char[] s = palindrome.toCharArray();
        for(int i = 0; i < len/2; i++) {
            if(s[i] != 'a') {
                s[i] = 'a';
                return String.valueOf(s);
            }
        }
        s[len - 1] = 'b';
        return String.valueOf(s);

    }
}
