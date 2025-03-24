import java.util.ArrayList;
import java.util.List;

public class DetectSquares {
    int[][] cntPoints;
    List<int[]> points;
    public DetectSquares(){
        cntPoints = new int[1001][1001];
        points = new ArrayList<>();
    }
    public void add(int[] point) {
        cntPoints[point[0]][point[1]] += 1;
        points.add(point);
    }
    public int count(int[] point) {
        int x1 = point[0], y1 = point[1];
        int res = 0;

        for(int[] p3 : points) {
            int x3 = p3[0], y3 = p3[1];
            if(Math.abs(x3 - x1) == 0 || Math.abs(x3 - x1) != Math.abs(y3 - y1))
                continue;
            res += cntPoints[x1][y3] * cntPoints[x3][y1];
        }
        return res;
    }
}
