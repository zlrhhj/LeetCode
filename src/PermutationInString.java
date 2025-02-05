public class PermutationInString {
    private boolean isMatch(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int len1 = s1.length();
        for(int i  = 0; i < len1; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            arr1[c1 - 'a']++;
            arr2[c2 - 'a']++;
        }
        if(isMatch(arr1, arr2)) return true;

        for(int i = len1; i < s2.length(); i++) {
            arr2[s2.charAt(i - len1) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
            if(isMatch(arr1, arr2)) return true;
        }
        return false;
    }
}
