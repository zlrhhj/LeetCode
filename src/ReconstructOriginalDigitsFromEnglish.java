public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        int[] digits = new int[10];
        digits[0] = letters['z' - 'a'];
        digits[2] = letters['w' - 'a'];
        digits[4] = letters['u' - 'a'];
        digits[6] = letters['x' - 'a'];
        digits[8] = letters['g' - 'a'];
        digits[1] = letters['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[3] = letters['h' - 'a'] - digits[8];
        digits[5] = letters['f' - 'a'] - digits[4];
        digits[7] = letters['v' - 'a'] - digits[5];
        digits[9] = letters['i' - 'a'] - digits[5] - digits[6] - digits[8];
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < digits[i]; j++) {
                result.append(i);
            }
        }
        return result.toString();
    }
}
