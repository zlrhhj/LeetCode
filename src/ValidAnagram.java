import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean validAnagram(String s, String t){
        int sLen = s.length();
        if(t.length() != sLen) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if(map.containsKey(s.charAt(i))) {
                int count = map.get(c);
                map.put(c, count+1);
            } else {
                map.put(c, 1);
            }
        }
        for(int i = 0; i < sLen; i++){
            if( !map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) <= 0 ) {
                return false;
            }
            char c = t.charAt(i);
            int count = map.get(c);
            map.put(c, count-1);
        }
        return true;
    }
}
