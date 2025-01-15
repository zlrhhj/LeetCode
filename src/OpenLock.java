import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList();
        int steps = 0;
        String start = "0000";
        if(visited.contains(start)) return -1;

        queue.add(start);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                String s = queue.remove();
                if(s.equals(target)) return steps;
                for(int j = 0; j < 4; j++) {
                    for(int k = -1; k <= 1; k+=2) {
                        StringBuilder next = new StringBuilder(s);
                        next.setCharAt(j, (char)((next.charAt(j) - '0' + k + 10) % 10 + '0'));
                        String n = next.toString();
                        if(!visited.contains(n) ) {
                            queue.add(n);
                            visited.add(n);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}