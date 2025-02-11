import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    int timestamp;
    String value;
    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
public class TimeMap {
    private Map<String, List<Pair>> map;
    TimeMap() {
        map = new HashMap<>();
    }
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            List<Pair> list = map.get(key);
            list.add(new Pair(timestamp, value));
        } else {
            List<Pair> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key,list);
        }
    }

    public String get(String key, int timestamp) {
        String res = "";
        if(map.containsKey(key))
        {
            List<Pair> list = map.get(key);
            int l = 0, r = list.size() - 1;
            while(l <= r) {
                int mid = l + (r - l) / 2;
                Pair pair = list.get(mid);
                if(pair.timestamp == timestamp) {
                    return pair.value;
                } else if(pair.timestamp > timestamp) {
                    r = mid - 1;
                } else {
                    res = pair.value;
                    l = mid + 1;
                }
            }
        }
        return res;
    }
}
