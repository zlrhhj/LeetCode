public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHigh = new int[n];
        int[] rightHigh = new int[n];
        for(int i = 1; i < n; i++) {
            leftHigh[i] = Math.max(leftHigh[i - 1], height[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--) {
            rightHigh[i] = Math.max(rightHigh[i + 1], height[i + 1]);
        }
        int water = 0;
        for(int i = 1; i < n - 1; i++) {
            int min = Math.min(leftHigh[i], rightHigh[i]);
            if(height[i] < min) {
                water += min - height[i];
            }
        }
        return water;
    }
}
