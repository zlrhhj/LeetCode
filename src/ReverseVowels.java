public class ReverseVowels {
    public String reverseVowels(String s) {
        String vowels = "aoeiuAOEIU";
        int start = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(start < end) {
            while(vowels.indexOf(arr[start]) == -1 && start < end) {
                start++;
            }
            while(vowels.indexOf(arr[end]) == -1 && start < end) {
                end--;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(arr);
    }
}
