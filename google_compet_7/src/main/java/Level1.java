import java.util.*;

public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        List<String> listOfStrings = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();

        int count;
        while (s.length() > 0) {
            if(s.length() <= len) {
                listOfStrings.add(s);
                s = "";
            } else {
                count = 0;
                for(int i = len; i > 0; i--) {
                    if(s.charAt(i) == ' ') {
                        count++;
                    }
                }
                if(count > 0) {
                    for(int i = len; i > 0; i--) {
                        if(s.charAt(i) == ' ') {
                            listOfStrings.add(s.substring(0, i));
                            s = s.substring((i + 1));
                            break;
                        }
                    }
                } else {
                    for(int i = len; i > 0; i--) {
                        listOfStrings.add(s.substring(0, i));
                        s = s.substring(i);
                        break;
                    }
                }
            }
        }

        for (int x=0; x<listOfStrings.size(); x++) {
            if(listOfStrings.get(x).contains(subs) && subs.length() == listOfStrings.get(x).length()) {
                digits.add(1);
            } else if (listOfStrings.get(x).contains(' ' + subs + ' ')) {
                digits.add(1);
            } else if (subs.charAt(0) == listOfStrings.get(x).charAt(0) && listOfStrings.get(x).contains(subs + ' ')) {
                digits.add(1);
            } else if (subs.charAt(subs.length() - 1) == listOfStrings.get(x).charAt(listOfStrings.get(x).length() - 1)
                    && listOfStrings.get(x).contains(' ' + subs)) {
                digits.add(1);
            } else digits.add(0);
        }

        int[] result = new int[digits.size()];
        for (int i=0; i<digits.size(); i++) result[i] = digits.get(i);

        return result;
    }
}
