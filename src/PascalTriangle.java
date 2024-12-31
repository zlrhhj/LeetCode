public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        result.add(r1);
        if(numRows > 1) {
            List<Integer> r2 = new ArrayList<>();
            r2.add(1);
            r2.add(1);
            result.add(r2);
            for(int i = 2; i < numRows; i++){
                List<Integer> r = new ArrayList();
                r.add(1);
                for(int j = 1; j < i; j++) {
                    List<Integer> lastList = result.get(i - 1);
                    int e = lastList.get(j - 1) + lastList.get(j);
                    r.add(e);
                }
                r.add(1);
                result.add(r);
            }
        }
        return result;
    }
}
