import java.util.*;
public class Level1 {
    public static String[] ShopOLAP(int N, String []items){
        int buffer = 0;
        Map<String, Integer> testMap2 = new TreeMap<String, Integer>();

        for(int i=0; i<N; i++) {
            String[] strElement = items[i].split(" ");
            if(testMap2.containsKey(strElement[0])) {
                buffer = testMap2.get(strElement[0]);
                testMap2.put(strElement[0], (Integer.parseInt(strElement[1]) + buffer));
            } else testMap2.put(strElement[0], Integer.parseInt(strElement[1]));
        }
        String resultStr = testMap2.toString();
        resultStr = resultStr.replaceAll("[{}]", "");
        resultStr = resultStr.replaceAll("=", " ");
        String[] resArray = resultStr.split(", ");

        return resArray;
    }
}