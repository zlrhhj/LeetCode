import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0;
        for(int i = 0; i < searchWord.length(); i++) {
            String subSearch = searchWord.substring(0, i + 1);
            int count = 0;
            List<String> list = new ArrayList<>();
            for(int j = start; j < products.length; j++) {
                if(products[j].length() < i + 1) continue;
                String subProduct = products[j].substring(0, i + 1);

                if(subSearch.equals(subProduct)) {
                    list.add(products[j]);
                    if(count == 0) start = j;
                    count++;
                    if(count == 3) break;
                }
            }
            result.add(list);
        }
        return result;
    }
}
