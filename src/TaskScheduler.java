import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastIntervals(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.add(i);
            }
        }
        int res = 0;
        while(!pq.isEmpty()) {
            int cycle = n + 1;
            while(cycle > 0 && !pq.isEmpty()) {
                freq[pq.remove()]--;
                res++;
                cycle--;
            }

            for(int i = 0; i < 26; i++){
                if(freq[i] > 0 && !pq.contains(i)) {
                    pq.add(i);
                }
            }
            if(cycle > 0 && !pq.isEmpty()) {
                res += cycle;
            }
        }
        return res;
    }
    //Atempt #2
    public int leastIntervals2(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks) {
            freq[task - 'A']++;
        }
        int max = 0;
        int maxCount = 0;
        for(int i : freq) {
            if(i == max) {
                maxCount++;
            } else if(i > max) {
                max = i;
                maxCount++;
            }
        }
        int res = (max - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
