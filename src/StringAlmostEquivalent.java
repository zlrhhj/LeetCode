public class StringAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] count = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            count[word1.charAt(i) - 'a']++;
            count[word2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(Math.abs(count[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
