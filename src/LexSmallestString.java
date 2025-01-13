import java.util.HashSet;
import java.util.Set;

public class LexSmallestString {
    private String answer;
    Set<String> set = new HashSet<>();
    public String findLexSmallestString(String s, int a, int b) {
        DFS(s, a, b);
        return answer;
    }
    private void DFS(String s, int a, int b) {
        if(set.contains(s)) {
            return;
        }
        if( answer == null || answer.compareTo(s) > 0) {
            answer = s;
        }
        set.add(s);
        DFS(add(s, a), a, b);
        DFS(rotate(s, b), a, b);
    }
    private String add(String s, int a) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 == 0) {
                str.append(s.charAt(i));
            } else {
                str.append((s.charAt(i) - '0' + a) % 10);
            }
        }
        return str.toString();
    }
    private String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b, n) + s.substring(0, n - b);
    }
}
