import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int result = 1;
        int preEnd = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] >= preEnd) {
                result++;
                preEnd = points[i][1];
            }
        }
        return result;

    }
}
