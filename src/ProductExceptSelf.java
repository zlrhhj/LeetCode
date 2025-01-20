public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zero = 0;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zero++;
            } else {
                product *= nums[i];
            }
        }
        if(zero > 1) return result;
        for(int i = 0; i < nums.length; i++) {
            if(zero == 0) {
                result[i] = product / nums[i];
            } else if(nums[i] == 0) {
                result[i] = product;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
}
