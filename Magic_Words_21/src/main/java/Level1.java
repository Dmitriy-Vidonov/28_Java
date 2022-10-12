import java.util.*;

public class Level1 {
    public static String BiggerGreater(String input){
        char temp;
        String bufferStr = "";
        ArrayList<String> bufferArray = new ArrayList<String>();

        for(int i=0; i<input.length(); i++) {
            for(int j=0; j<input.length(); j++) {
                if (i == j) continue;
                else {
                    temp = input.charAt(j);
                    char[] tempArr = input.toCharArray();
                    temp = tempArr[j];
                    tempArr[j] = tempArr[i];
                    tempArr[i] = temp;
                    bufferStr = String.valueOf(tempArr);

                    if(!(bufferArray.contains(bufferStr))) bufferArray.add(bufferStr);
                }
            }
        }

        for(int i=0; i < bufferArray.size(); i++) {
            LetterReplace(bufferArray.get(i));
        }

        ArrayList<String> biggerArr = new ArrayList<String>();
        if(input.length() == 2) biggerArr.addAll(BiggerArrComplete(bufferArray, input));
        else biggerArr.addAll(BiggerArrComplete(mainBufferArray, input));

        String lessWord = "";
        if(biggerArr.size() > 0) lessWord = biggerArr.get(0);
        for(int i=0; i<biggerArr.size(); i++) {
            if(compareStrings(biggerArr.get(i), lessWord) < 0) {
                lessWord = biggerArr.get(i);
            }
        }

        if(compareStrings(lessWord, input) > 0) return lessWord;
        else return "";

    }

    public static int compareStrings(String s1, String s2) {

        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if ((int) s1.charAt(i) == (int) s2.charAt(i)) {
                continue;
            } else {
                return (int) s1.charAt(i) - (int) s2.charAt(i);
            }
        }
        if (s1.length() < s2.length()) {
            return (s1.length() - s2.length());
        } else if (s1.length() > s2.length()) {
            return (s1.length() - s2.length());
        } else {
            return 0;
        }
    }

    public static void LetterReplace(String str) {
        char temp;
        String bufferStr = "";
        for(int i=0; i<str.length(); i++) {
            mainBufferArray.add(str);
            for(int j=0; j<str.length(); j++) {
                if (i == j) continue;
                else {
                    temp = str.charAt(j);
                    char[] tempArr = str.toCharArray();
                    temp = tempArr[j];
                    tempArr[j] = tempArr[i];
                    tempArr[i] = temp;
                    bufferStr = String.valueOf(tempArr);
                    if(!mainBufferArray.contains(bufferStr)
                            && !mainBufferArray.contains(strReplace)) mainBufferArray.add(bufferStr);
                }
            }
        }
    }

    public static ArrayList<String> BiggerArrComplete(ArrayList<String> arrList, String strReplace) {
        ArrayList<String> biggerArr = new ArrayList<String>();
        for(int i=0; i<arrList.size(); i++) {
            if(compareStrings(arrList.get(i), strReplace) > 0) biggerArr
                    .add(arrList.get(i));
            else continue;
        }
        return biggerArr;
    }
    public static ArrayList<String> mainBufferArray = new ArrayList<String>();
    public static String strReplace;
}
