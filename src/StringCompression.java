public class StringCompression {
    public int compress(char[] chars) {
        int result = 0;
        for(int i = 0; i < chars.length;) {
            char letter = chars[i++];
            chars[result++] = letter;
            int count = 1;
            while(i < chars.length && chars[i] == letter) {
                count++;
                i++;
            }
            if(count > 1) {
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[result++] = c;
                }
            }
        }
        return result;
    }
}
