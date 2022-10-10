import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        String str = "abлм";
        System.out.println("a = " + (int)str.charAt(0));
        System.out.println("b = " + (int)str.charAt(1));
        System.out.println("л = " + (int)str.charAt(2));
        System.out.println("м = " + (int)str.charAt(3));

        String strReplace = "нкмл";
        char temp;
        String bufferStr = ""; //буферная строка, для хранения промежуточных значений
        ArrayList<String> bufferArray = new ArrayList<String>(); //массив, в который будем заносить полученные перестановки
        for(int i=0; i<strReplace.length(); i++) { //основной цикл по каждой букве
            for(int j=0; j<strReplace.length(); j++) { //в этом цикле будем сдвигать буквы
                if (i == j) continue;
                else {
                    //поменять местами символы в массиве, потом полученное записать в строку
                   temp = strReplace.charAt(j);
                    char[] tempArr = strReplace.toCharArray();
                    temp = tempArr[j];//к
                    tempArr[j] = tempArr[i];
                    tempArr[i] = temp;
                    bufferStr = String.valueOf(tempArr);

                   if(!(bufferArray.contains(bufferStr))) bufferArray.add(bufferStr);
                }
            }
        }
        //задаем массив для слов, которые лексикографически больше исходного
        ArrayList<String> biggerArr = new ArrayList<String>();
        for(int i=0; i<bufferArray.size(); i++) {
            //в массив biggerArr заносим только те слова, которые лексикографически больше исходного
            if(Methods.compareStrings(bufferArray.get(i), strReplace) > 0) biggerArr.add(bufferArray.get(i));
            else continue;
        }
        //теперь в массиве biggerArr надо найти наименьшее лексикографически слово
        String lessWord = biggerArr.get(0);
        for(int i=0; i<biggerArr.size(); i++) {
            if(Methods.compareStrings()) {

            }
        }

        //тестовый вывод полученного буферного массива
        for(String word : bufferArray) System.out.print(word + " ");
        System.out.println();
        for(String word : biggerArr) System.out.print(word + " "); //нмкл нлмк
    }
}
