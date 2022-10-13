import java.util.*;

public class Level1 {
    public static boolean SherlockValidString(String s) {
        ArrayList<Character> strArray = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            strArray.add(s.charAt(i));
        }

        Set<Character> set = new HashSet<>(strArray);
        strArray.clear();
        strArray.addAll(set);

        List<Integer> nums = new ArrayList<>();
        for(char word : strArray) {
            int buff_count = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == word) buff_count++;
            }
            nums.add(buff_count);
        }
        Collections.sort(nums);

        int minEl = Collections.min(nums);
        int maxEl = Collections.max(nums);
        int minCount = 0;
        int maxCount = 0;
        for(int digit : nums) {
            if(digit == minEl) minCount++;
            else if (digit == maxEl) maxCount++;
        }

        return ((maxCount > 0 && (((maxEl - minEl) == 1) && (maxCount == 1 || minCount == 1))) || maxCount == 0);
    }
}
