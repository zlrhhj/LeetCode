import java.util.ArrayList;
import java.util.List;

public class RemoveAnagrams {
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String pre = words[0];
        result.add(pre);
        for(int i = 1; i < words.length; i++) {
            if(!isAnagram(pre, words[i])) {
                result.add(words[i]);
                pre = words[i];
            }
        }
        return result;
    }
    private boolean isAnagram(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] letters = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            letters[word1.charAt(i) - 'a']++;
            letters[word2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(letters[i] != 0) return false;
        }
        return true;
    }
}
