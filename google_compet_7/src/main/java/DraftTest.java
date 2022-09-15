import java.util.*;

public class Test {
    public static void main(String[] args) {
        String stroka = "алес гуттендецум гебойген!";
        int len = 8;

        //перевод строки в массив строк
        String[] words = stroka.split(" ");

        //каждое слово переводим в массив символов
        char[][] wordsArray = new char[words.length][];
        for(int i=0; i< words.length; i++) {
            wordsArray[i] = words[i].toCharArray();
        }
        //for(char[] count : wordsArray) System.out.println(count); //тестовый вывод слов из массива слов

        char[][] matrix = new char[len][len];
        // 1.1 сначала возьмем строку из одного слова и поместим в нашу матрицу (длина слова меньше len)
        /*for(int i=0; i<wordsArray.length-2; i++) { //основной цикл по словам. число итераций = числу слов в строке
            for(int letter=0; letter<wordsArray[i].length; letter++) { //цикл по буквам внутри слова
                matrix[0][letter] = wordsArray[i][letter]; //в 0-ую строку матрицы добавить посимвольно слово из wordsArray
            }
        }*/

        // 1.2 затем так же попробуем поместить туда строку из одного слова по длине len
        /*for(int i=0; i<wordsArray.length-2; i++) { //основной цикл по словам. число итераций = числу слов в строке
            for(int letter=0; letter<wordsArray[i].length; letter++) { //цикл по буквам внутри слова
                matrix[0][letter] = wordsArray[i][letter]; //в 0-ую строку матрицы добавить посимвольно слово из wordsArray
            }*/

        // 1.3  - затем попробуем вместить слово длиннее len
        //добавить проверку - если слово длиннее len, то цикл провести по len, перейти на новую строку и продолжить
        //добавление слова с индекса = len
        //перенос на другую строку - это прибавление координаты matrix[rows], а cols - с нуля
        /*int karetka=0;
        if(wordsArray[0].length > len) { //проверка что длина слова больше len
            for(int letter=0; letter<len; letter++) { //цикл по буквам внутри слова
                matrix[0][letter] = wordsArray[0][letter]; //в 0-ую строку матрицы добавить посимвольно слово из wordsArray
            } karetka=0;

            for(int letter=len; letter<wordsArray[0].length; letter++) { //вторая строка
                matrix[1][karetka] = wordsArray[0][letter];
                karetka++;
            }
        } */

        // 1.4 - затем попробуем поместить два слова общей длиной менее len
        /*int karetka=0;
        if((wordsArray[0].length + wordsArray[1].length + 1) >= len) { //если в строку помещаются 2 слова целиком
            for(int letter=0; letter<wordsArray[0].length; letter++) { //цикл по первому слову
                matrix[0][karetka] = wordsArray[0][letter]; karetka++;
            } karetka++; //передвигаем каретку для пробела
            matrix[0][karetka] = ' '; //ставим пробел после первого слова

            for(int letter=0; letter<wordsArray[1].length; letter++) { //цикл по второму слову
                matrix[0][karetka] = wordsArray[1][letter];
                if(karetka < len) karetka++;
            }
        }*/

        // 1.5  - затем попробуем вместить два слова, общая длина которых больше len
        /*int i, karetka;
        i = karetka = 0;
        if((wordsArray[i].length + wordsArray[i+1].length) > len) {

            for(int letter=0; letter<wordsArray[i].length; letter++) { //вписываем первое слово
                matrix[i][karetka] = wordsArray[i][letter]; karetka++;
            } karetka=0; //обнуление каретки при переходе на новую строку. когда добавляем +1 к rows у matrix

            for(int letter=0; letter<wordsArray[i+1].length; letter++) { //вписываем второе слово
                matrix[i+1][karetka] = wordsArray[i+1][letter]; karetka++;
            }
        }*/

        // 1.6  - затем пробуем вторым словом вместить слово длиннее len
        int i, karetka;
        i = karetka = 0;
            for(int letter=0; letter<wordsArray[i].length; letter++) {
                matrix[i][karetka] = wordsArray[i][letter]; karetka++;
            } karetka=0;

            if(wordsArray[i+1].length > len) {
                for(int letter=0; letter<len; letter++) { //цикл по буквам внутри слова
                    matrix[i+1][letter] = wordsArray[i+1][letter]; //в 0-ую строку матрицы добавить посимвольно слово из wordsArray
                } karetka=0;

                for(int letter=len; letter<wordsArray[i+1].length; letter++) { //вторая строка
                    matrix[i+2][karetka] = wordsArray[i+1][letter];
                    karetka++;
                }
            }
            
       /* for(int i=0; i<wordsArray.length-2; i++) { //основной цикл по словам. число итераций = числу слов в строке
            for(int letter=0; letter<wordsArray[i].length; letter++) { //цикл по буквам внутри слова
                matrix[0][letter] = wordsArray[i][letter]; //в 0-ую строку матрицы добавить посимвольно слово из wordsArray
            } */

        //проверить результат выполнения - выведем массив matrix на экран
        for(int i1=0; i1<matrix.length; i1++) {
            for(int j1=0; j1<matrix[0].length; j1++) {
                System.out.print(matrix[i1][j1]);
            }
            System.out.println();
        }
    }
}
