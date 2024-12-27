import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);

            if(!groups.containsKey(key)) {
                groups.put(key, new ArrayList());
            }
            groups.get(key).add(str);

        }
        return new ArrayList(groups.values());
    }
}