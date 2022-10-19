import java.util.*;

public class Level1 {
    public static boolean white_walkers(String village) {
        int startNum, endNum, sum;
        startNum = endNum = sum = -1;
        List<Integer> pairs = new ArrayList<>();
        List<Integer> equals = new ArrayList<>();
        boolean startNumInstall, endNumInstall;
        endNumInstall = startNumInstall = false;
        int equalsCount, startIndex, endIndex, count;
        equalsCount = startIndex = endIndex = count = 0;

        while (count < village.length()) {
            if (Character.isDigit(village.charAt(count)) && startNumInstall == false && endNumInstall == false) {
                startNum = village.charAt(count) - '0';
                startNumInstall = true;
                startIndex = count;
                sum = -1;
            }
            else if (Character.isDigit(village.charAt(count)) && startNumInstall == true && endNumInstall == false) {
                endNum = village.charAt(count) - '0';
                endNumInstall = true;
                endIndex = count;
                sum = startNum + endNum;
            }
            else if (Character.isDigit(village.charAt(count)) && startNumInstall == true && endNumInstall == true) {
                startNum = endNum;
                startIndex = endIndex;
                endNum = village.charAt(count) - '0';
                endIndex = count;
                sum = startNum + endNum;
            }
            if(sum == 10) {
                pairs.add(sum);
                equals.add(EqualsCount(village, startIndex, endIndex));
            }
            sum = -1;
            count++;
        }
        return  (pairs.size() > 0 && isOnlyOneDigit(equals, 3));
    }

    public static int EqualsCount(String str, int startIndex, int endIndex) {
        int res = 0;
        for(int i=startIndex; i<endIndex; i++) if(str.charAt(i) == '=') res++;
        return res;
    }

    public static boolean isOnlyOneDigit(List<Integer> list, int digit) {
        boolean res = true;
        for(int nums : list) if (nums != digit) res = false;
        return res;
    }
}
