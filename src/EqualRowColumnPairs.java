import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class TrieNode {
    int count;
    Map<Integer, TrieNode> children;
    public TrieNode() {
        this.count = 0;
        this.children = new HashMap<>();
    }
}
class Trie {
    TrieNode trie;
    public Trie() {
        this.trie = new TrieNode();
    }
    public void insert(int[] array) {
        TrieNode myTrie = this.trie;
        for (int a : array) {
            if(!myTrie.children.containsKey(a)) {
                myTrie.children.put(a,new TrieNode());
            }
            myTrie = myTrie.children.get(a);
        }
        myTrie.count += 1;
    }

    public int search(int[] array) {
        TrieNode myTrie = this.trie;
        for (int a : array ) {
            if(myTrie.children.containsKey(a)) {
                myTrie = myTrie.children.get(a);
            } else {
                return 0;
            }
        }
        return myTrie.count;
    }
}
public class EqualRowColumnPairs {
    public int equalPairs(int[][] grid) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;
        for(int i = 0; i < n; i++) {
            map.put(Arrays.toString(grid[i]), map.getOrDefault(Arrays.toString(grid[i]),0) + 1);
        }

        for(int i = 0; i < n; i++) {
            int[] column = new int[n];
            for(int j = 0; j < n; j++){
                column[j] = grid[j][i];
            }
            if(map.containsKey(Arrays.toString(column))) {
                result += map.get(Arrays.toString(column));
            }
        }
        return result;
    }
    public int equalPairs1 (int[][] grid) {
        Trie trie = new Trie();
        int count = 0;
        for ( int[] row : grid ) {
            trie.insert(row);
        }

        for ( int i = 0; i < grid.length; i++ ) {
            int[] column = new int[grid.length];
            for ( int r = 0; r < grid.length; r++ ) {
                column[r] = grid[r][i];
            }
            count += trie.search( column );
        }
        return count;
    }
}
