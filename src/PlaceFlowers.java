public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for(int i = 0; i < len; i++) {
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0 ? true: false;
    }
}
