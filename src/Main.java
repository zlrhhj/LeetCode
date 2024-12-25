public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LongestOnes longest = new LongestOnes();
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int result = longest.longestOnes(nums, 3);
        System.out.println(result);
    }
}