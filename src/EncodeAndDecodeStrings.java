import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    public String encode(String[] strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs) {
            encodedString.append(str);
            encodedString.append("π");
        }
        encodedString.delete(encodedString.length() - 1, encodedString.length());
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] decodedStrings = s.split("π", -1);
        return new ArrayList<String>(Arrays.asList(decodedStrings));
    }
}
