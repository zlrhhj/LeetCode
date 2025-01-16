public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;
        for(; i < Math.min(len1, len2); i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if(i < len1) return result.toString() + word1.substring(i);
        return result.toString() + word2.substring(i);
    }
}
