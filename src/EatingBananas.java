public class EatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];
        for(int pile : piles) {
            right = Math.max(pile, right);
        }
        while(left < right) {
            int mid = left + (right - left) / 2;
            int hourSpent = 0;
            for(int pile : piles) {
                hourSpent += Math.ceil(( ( double ) pile / mid ));
            }
            if(hourSpent > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
