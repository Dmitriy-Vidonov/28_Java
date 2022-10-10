import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        String str = "abлм";
        System.out.println("a = " + (int)str.charAt(0));
        System.out.println("b = " + (int)str.charAt(1));
        System.out.println("л = " + (int)str.charAt(2));
        System.out.println("м = " + (int)str.charAt(3));
        int i, j; i=j=0;
        String strReplace = "нкмл";
        char[] strToArr = strReplace.toCharArray();
        String bufferStr = ""; //буферная строка, для хранения промежуточных значений
        ArrayList<String> bufferArray = new ArrayList<String>(); //массив, в который будем заносить полученные перестановки
        for(i=0; i<strReplace.length(); i++) { //основной цикл по каждой букве
            for(j=0; j<strReplace.length(); j++) { //в этом цикле будем сдвигать буквы
                if (strReplace.charAt(i) == strReplace.charAt(j)) continue;
                else {
                    //поменять местами символы в массиве, потом полученное записать в строку
                    char temp;
                    temp = strToArr[i];
                    strToArr[i] = strToArr[j];
                    strToArr[j] = temp;

                    bufferStr = strToArr.toString();
                    bufferArray.add(bufferStr);
                }
            }
        }
        //тестовый вывод полученного буферного массива
        for(String word : bufferArray) System.out.print(word + " ");
    }
}
