public class JumpGameII {
    public int jump(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length, farest = 0;

        int answer = 0;
        while(right < nums.length - 1) {
            for(int i = left; i <= right; i++) {
                farest = Math.max(farest, i + nums[i]);
            }
            left = right;
            right = farest;
            answer++;
        }
        return answer;
    }
}
