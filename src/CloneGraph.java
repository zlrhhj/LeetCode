import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    Map<GraphNode, GraphNode> visited = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) return node;
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        GraphNode cloneNode = new GraphNode(node.val, new ArrayList<>());
        for(GraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}
