public class Level1 {
    public static boolean LineAnalysis(String line) {
        char[] chArr = line.toCharArray();
        int stars = 1;
        int dots = 0;
        int index = 1;
        boolean result = true;

        if (chArr.length > 1 && chArr[0] == '*')  {
            while(chArr[index] != '*' && chArr.length > 1) {
                dots++;
                index++;
            }
        } else if (chArr.length == 1 && chArr[0] == '*') {
            return result;
        } else {
            result = false;
        }

        String subStr = line.substring(0, (dots + stars));
        int StrPartStart = 0;
        int StrPartEnd = dots + stars;
        int checks = 0;

        for (int i = 0; i <= chArr.length-1 && i + (dots + stars) <= chArr.length-1
                && chArr.length >= (dots + stars) && chArr[chArr.length-1] == '*'
                && chArr[0] == '*'; i += (dots + stars)) {
            if (line.substring(i, i + (dots + stars)).equals(subStr) == true) {
                checks++;
            } else {
                break;
            }
        }

        if (checks == (chArr.length-1) / (dots + stars) && (chArr.length-1) % (dots + stars) == 0) return true;
        else return false;
    }
}
