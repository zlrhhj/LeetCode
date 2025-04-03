import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sWindowMap = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0, r = 0;
        int formed = 0;
        int[] ans = { Integer.MAX_VALUE, 0, 0};
        while(r < s.length()){
            char c = s.charAt(r);
            if(tMap.containsKey(c)) {
                int count = sWindowMap.getOrDefault(c, 0);
                sWindowMap.put(c, count + 1);
                if(tMap.get(c) == count + 1) {
                    formed++;
                }
                while(l <= r &&formed == tMap.size()) {
                    if(r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }
                    c = s.charAt(l);
                    l++;
                    if(sWindowMap.containsKey(c)){
                        sWindowMap.put(c, sWindowMap.get(c) - 1);
                        if(sWindowMap.get(c) < tMap.get(c)) {
                            formed--;
                        }
                    }
                }

            }

            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
