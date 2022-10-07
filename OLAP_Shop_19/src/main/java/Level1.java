import java.util.*;

public class Level1 {
    public static String[] ShopOLAP(int N, String []items){
        int buffer = 0;
        Map<String, Integer> testMap = new TreeMap<String, Integer>();

        for(int i=0; i<N; i++) {
            String[] strElement = items[i].split(" ");
            if(testMap.containsKey(strElement[0])) {
                buffer = testMap.get(strElement[0]);
                testMap.put(strElement[0], (Integer.parseInt(strElement[1]) + buffer));
            } else testMap.put(strElement[0], Integer.parseInt(strElement[1]));
        }
        testMap = sortByValue(testMap);
        String resultStr = testMap.toString();
        resultStr = resultStr.replaceAll("[{}]", "");
        resultStr = resultStr.replaceAll("=", " ");
        String[] resArray = resultStr.split(", ");

        return resArray;
    }
    
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
