public class LexicographicallySmallestStringAfterSwap {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1] && (arr[i] - '0' + arr[i + 1] - '0') % 2 == 0){
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp ;
                break;
            }
        }
        return String.valueOf(arr);
    }
}
