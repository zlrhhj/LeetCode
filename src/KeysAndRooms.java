import java.util.*;

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

    public boolean canVisitAllRooms1 (List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                for(int key : rooms.get(queue.remove())) {
                    if(visited.add(key)) {
                        queue.add(key);
                    }
                }
            }
        }
        return visited.size() == rooms.size() ? true : false;
    }
}
