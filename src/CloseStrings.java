import java.util.Arrays;

public class CloseStrings {
    public boolean closeStrings(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(word1.length() != word2.length()) return false;
        for(int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            arr1[c - 'a'] += 1;
            c = word2.charAt(i);
            arr2[c - 'a'] += 1;
        }
        for(int i = 0; i < 26; i++) {
            if((arr1[i] == 0 && arr2[i] > 0) || (arr1[i] > 0 && arr2[i] == 0))
                return false;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.toString(arr1).equals(Arrays.toString(arr2));
    }
}
