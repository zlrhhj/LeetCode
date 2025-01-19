public class StringsGreatestCommonDivisor {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1 + str2;
        String s2 = str2 + str1;

        if(!s1.equals(s2)) return "";
        int d = gcd(str1.length(), str2.length());
        return str1.substring(0, d);
    }
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
