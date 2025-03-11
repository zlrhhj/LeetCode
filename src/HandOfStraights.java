public class HandOfStraights {
    public boolean helper(int[] hand, int groupSize, int index) {
        int n = hand.length;
        int goal = hand[index] + 1;
        hand[index] = -1;
        index++;
        int count = 1;
        while(index < n && count < groupSize) {
            if(hand[index] == goal) {
                goal = hand[index] + 1;
                hand[index] = -1;
                count++;
            }
            index++;
        }
        if(count == groupSize) return true;
        return false;
    }
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0 ) return false;
        for(int i = 0; i < n; i++) {
            if(hand[i] > 0 && !helper(hand, groupSize,i)) return false;
        }
        return true;
    }
}
