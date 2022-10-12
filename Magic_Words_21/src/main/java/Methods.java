import java.util.ArrayList;

public class Methods {
    public static ArrayList<String> mainBufferArray = new ArrayList<String>();

    //метод для перестановки букв в массиве
    public static void LetterReplace(String str) {
        char temp;
        String bufferStr = "";
        for(int i=0; i<str.length(); i++) { //основной цикл по каждой букве
            mainBufferArray.add(str);
            for(int j=0; j<str.length(); j++) { //в этом цикле будем сдвигать буквы
                if (i == j) continue;
                else {
                    temp = str.charAt(j);
                    char[] tempArr = str.toCharArray();
                    temp = tempArr[j];//к
                    tempArr[j] = tempArr[i];
                    tempArr[i] = temp;
                    bufferStr = String.valueOf(tempArr);
                    if(!mainBufferArray.contains(bufferStr) && !mainBufferArray.contains(Test2.strReplace)) mainBufferArray.add(bufferStr);
                }
            }
        }
    }

    //метод заполнения массива biggerArr
    public static ArrayList<String> BiggerArrComplete(ArrayList<String> arrList, String strReplace) {
        ArrayList<String> biggerArr = new ArrayList<String>();
        for(int i=0; i<arrList.size(); i++) {
            //в массив biggerArr заносим только те слова, которые лексикографически больше исходного
            if(Methods.compareStrings(arrList.get(i), strReplace) > 0) biggerArr
                    .add(arrList.get(i));
            else continue;
        }
        return biggerArr;
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
    private static void getComparisonResult(int value, String s1, String s2) {
        if (value > 0) {
            System.out.println(s1 + " больше " + s2);
        } else if (value < 0) {
            System.out.println(s1 + " меньше " + s2);
        } else {
            System.out.println(s1 + " и " + s2 + " равны");
        }
    }
}
