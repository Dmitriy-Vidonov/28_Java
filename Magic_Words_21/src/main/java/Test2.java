import java.util.ArrayList;

public class Test2 {
    public static String strReplace;
    public static void main(String[] args) {
        String str = "abлм";
        System.out.println("a = " + (int)str.charAt(0));
        System.out.println("b = " + (int)str.charAt(1));
        System.out.println("л = " + (int)str.charAt(2));
        System.out.println("м = " + (int)str.charAt(3));

        String strReplace = "ckib";
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
        //ArrayList<String> bufferArrayFull = new ArrayList<String>();
        //for(String word : bufferArray) bufferArrayFull.add(word); //в bufferArrayFull занесли содержимое предыдущего массива

        //для каждого элемента bufferArray - надо проделать такую же перестановку
        for(int i=0; i < bufferArray.size(); i++) {
            Methods.LetterReplace(bufferArray.get(i));
        }
        System.out.print("main BUFFER = ");
        for(String word : Methods.mainBufferArray) System.out.print(word + ", "); System.out.println();

        //задаем массив для слов, которые лексикографически больше исходного
        //задать метод для заполнения biggerArr. Если длина строки = 2, подставим туда bufferArray, иначе - main buffer

        ArrayList<String> biggerArr = new ArrayList<String>();
       /* for(int i=0; i<Methods.mainBufferArray.size(); i++) {
            //в массив biggerArr заносим только те слова, которые лексикографически больше исходного
            if(Methods.compareStrings(Methods.mainBufferArray.get(i), strReplace) > 0) biggerArr
                    .add(Methods.mainBufferArray.get(i));
            else continue;
        }*/

        if(strReplace.length() == 2) biggerArr.addAll(Methods.BiggerArrComplete(bufferArray, strReplace));
        else biggerArr.addAll(Methods.BiggerArrComplete(Methods.mainBufferArray, strReplace));

        //теперь в массиве biggerArr надо найти лексикографически наименьшее слово
        String lessWord = "";
        if(biggerArr.size() > 0) lessWord = biggerArr.get(0);
        for(int i=0; i<biggerArr.size(); i++) {
            if(Methods.compareStrings(biggerArr.get(i), lessWord) < 0) {
                lessWord = biggerArr.get(i);
            }
        }
        System.out.println("Наименьшее лексикографическое слово в biggerArr = " + lessWord);

        //Сравнить наименьшее лексикографическое с исходным словом. Больше ли новое слово чем начальное?
        if(Methods.compareStrings(lessWord, strReplace) > 0) System.out.println("слово " + lessWord
                + " - магическое!");
        else System.out.println("магического слова нет");

        //тестовый вывод полученного буферного массива
        System.out.print("bufferArray = ");
        for(String word : bufferArray) System.out.print(word + " ");
        System.out.println();
        System.out.print("biggerArr = ");
        for(String word : biggerArr) System.out.print(word + " ");
        System.out.println();

    }
}
