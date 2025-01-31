import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> queueR = new LinkedList<>();
        Queue<Integer> queueD = new LinkedList<>();

        int n = senate.length();
        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                queueR.add(i);
            } else {
                queueD.add(i);
            }
        }
        while(!queueD.isEmpty() && !queueR.isEmpty()) {
            int r = queueR.remove();
            int d = queueD.remove();
            if(r < d) {
                queueR.add(r + n);
            } else {
                queueD.add(d + n);
            }
        }
        return queueD.isEmpty() ? "Radiant" : "Dire";
    }
}
