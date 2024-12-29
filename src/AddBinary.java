public class AddBinary {
    public String addBinary(String a, String b){
        int aLen = a.length();
        int bLen = b.length();
        StringBuilder result = new StringBuilder();
        int ap = aLen - 1;
        int bp = bLen - 1;
        int carries = 0;
        int tempResult = 0;
        while(ap >= 0 && bp >= 0) {
            tempResult = ((a.charAt(ap) - '0') + (b.charAt(bp) - '0') + carries);
            result.append(tempResult % 2);
            carries = tempResult/2;
            ap--;
            bp--;
        }
        while(ap >= 0) {
            tempResult = (a.charAt(ap) - '0') + carries;
            result.append(tempResult % 2);
            carries = (tempResult)/2;
            ap--;
        }
        while(bp >= 0) {
            tempResult = (b.charAt(bp) - '0') + carries;
            result.append(tempResult % 2);
            carries = (tempResult)/2;
            bp--;
        }
        if(carries != 0 ) {
            result.append(carries);
        }
        return result.reverse().toString();
    }
}
