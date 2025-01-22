public class MaxVowels {
    public int maxVowels(String s, int k) {
        int count = 0;
        String vowels = "aoeiu";
        for( int i = 0; i < k; i++ ) {
            count += vowels.indexOf(s.charAt(i)) == -1 ? 0 : 1;
        }
        int result = count;

        for( int i = k; i < s.length(); i++ ) {
            count += vowels.indexOf(s.charAt(i)) == -1 ? 0 : 1;
            count -= vowels.indexOf(s.charAt(i - k)) == -1 ? 0 : 1;
        }
        result = Math.max(result, count);
        return result;
    }
}
