import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public void dfs(int key, List<List<Integer>> rooms, Set<Integer> visited) {
        for(int room : rooms.get(key)) {
            if(visited.add(room)) {
                dfs(room, rooms, visited);
            }
        }
    }
    public boolean canVisitAllRooms (List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        dfs(0, rooms, visited);
        return visited.size() == rooms.size() ? true : false;
    }
}
