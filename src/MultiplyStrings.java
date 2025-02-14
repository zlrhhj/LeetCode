public class MultiplyStrings {
    public String multiplyStrings(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length() + num2.length();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < n; i++) {
            ans.append(0);
        }
        StringBuilder firstNum = new StringBuilder(num1);
        StringBuilder secondNum = new StringBuilder(num2);
        firstNum.reverse();
        secondNum.reverse();
        for(int p1 = 0; p1 < firstNum.length(); p1++) {
            int digit1 = firstNum.charAt(p1) - '0';
            for(int p2 = 0; p2 < secondNum.length(); p2++) {
                int digit2 = secondNum.charAt(p2) - '0';

                int product = digit1 * digit2;
                int currentPos = p1 + p2;
                int carry = ans.charAt(currentPos) - '0';
                ans.setCharAt(currentPos, (char) ((product + carry) % 10 + '0'));
                int value = (product + carry) / 10 + ans.charAt(currentPos + 1) - '0';
                ans.setCharAt(currentPos + 1, (char) (value + '0'));
            }
        }
        if(ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1 );
        }
        return ans.reverse().toString();
    }
}
