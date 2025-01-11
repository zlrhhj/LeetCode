import java.util.*;

public class DisplayTables {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> items = new TreeSet<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        for(List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String item = order.get(2);
            items.add(item);
            Map<String, Integer> tableItems = map.getOrDefault(table, new HashMap());
            int count = tableItems.getOrDefault(item, 0);
            tableItems.put(item, count + 1);
            map.put(table, tableItems);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> schema = new ArrayList<>();
        schema.add("Table");
        for(String item: items) {
            schema.add(item);
        }
        result.add(schema);
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int key : keys) {
            List<String> row = new ArrayList<>();
            row.add(Integer.toString(key));
            for(String item:items) {
                row.add(Integer.toString(map.get(key).getOrDefault(item, 0)));
            }
            result.add(row);
        }
        return result;
    }
}
