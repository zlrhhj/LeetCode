public class RemoveColoredPieces {
    public boolean winnerOfGames(String colors) {
        int a = 0;
        int b = 0;
        if( colors.length() > 2 ){
            for(int i = 0; i < colors.length() - 2; i++){
                if(colors.charAt(i) == colors.charAt(i+1) && colors.charAt(i+1) == colors.charAt(i+2)) {
                    if(colors.charAt(i) == 'A'){
                        a++;
                    } else {
                        b++;
                    }
                }
            }
            return a > b ? true : false;
        }
        return false;
    }
}
