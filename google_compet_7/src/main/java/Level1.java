import java.util.*;

public class Level1 {
    public static int[] WordSearch(int len, String s, String subs) {
        List<String> spisok_strok = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();

        int count;
        while (s.length() > 0) {
            if(s.length() <= len) {
                spisok_strok.add(s);
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
                            spisok_strok.add(s.substring(0, i));
                            s = s.substring((i + 1));
                            break;
                        }
                    }
                } else {
                    for(int i = len; i > 0; i--) {
                        spisok_strok.add(s.substring(0, i));
                        s = s.substring(0,i);
                        break;
                    }
                }
            }
        }

        for (int x=0; x<spisok_strok.size(); x++) {
            if(spisok_strok.get(x).contains(subs) && subs.length() == spisok_strok.get(x).length()) {
                digits.add(1);
            } else if (spisok_strok.get(x).contains(' ' + subs + ' ')) {
                digits.add(1);
            } else if (subs.charAt(0) == spisok_strok.get(x).charAt(0) && spisok_strok.get(x).contains(subs + ' ')) {
                digits.add(1);
            } else if (subs.charAt(subs.length() - 1) == spisok_strok.get(x).charAt(spisok_strok.get(x).length() - 1)
                    && spisok_strok.get(x).contains(' ' + subs)) {
                digits.add(1);
            } else digits.add(0);
        }

        int[] result = new int[digits.size()];
        for (int i=0; i<digits.size(); i++) result[i] = digits.get(i);

        return result;
    }
}
