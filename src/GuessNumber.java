public class GuessNumber {
    public int guessNumber(int n) {
        int start = 1, end = n;

        while(start <= end) {
            int num = start + (end - start) / 2 ;
            if(guess(num) == 0) return num;
            if(guess(num) == -1) end = num - 1;
            if(guess(num) == 1) start = num + 1;
        }
        return -1;
    }
}