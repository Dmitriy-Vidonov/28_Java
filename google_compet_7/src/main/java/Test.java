public class Test {
    public static void main(String[] args) {
        String stroka = "одно слово дваа словаа трисловиссимо";
        //можем ли мы превратить строку в массив слов?
        String[] words = stroka.split(" ");
        for(String word : words) System.out.println(word); //вывод массива слов из строки

        //можем ли мы разбить слово по числу символов? например - слово из 5 букв на два слова из 2 и 3 букв?
        //Да. Это "извлечение символов"
        int len = 10;
        String word = "трисловиссимо";
        int start = len; //начало обрезки, равное len
        int end = word.length(); //конец обрезки, равное концу слова
        char[] piece = new char[end - start];
        word.getChars(start, end, piece, 0);
        System.out.println(piece);


        char[][] matrix = new char[len][len];
        //word.getChars(0, len, matrix[0], 0);
        //System.out.println(matrix[0]);
        (words[0]+" "+words[1]).getChars(0, len, matrix[0], 0); //добавили первое слово в matrix
        words[2].getChars(0, words[2].length(), matrix[1], 0); //заполнение второй строки matrix
        words[3].getChars(0, words[3].length(), matrix[2], 0); //заполняем 3-ю строку matrix
        words[4].getChars(0, len, matrix[3], 0);
        words[4].getChars(len, words[4].length(), matrix[4], 0);

        //вывод матрицы
        System.out.println("Вывод Matrix:");
        for(int i=0; i<len; i++) {
          System.out.println(matrix[i]);
        }

        String sub = "ловаа";
        int[] resArr = new int[5];
        //найти слово в массиве
        for (int i=0; i< matrix.length; i++) {
            String str = new String(matrix[i]);
            if(str.contains(sub)) {
                resArr[i] = 1;
            }
        }
        for(int count : resArr) System.out.print(count + " "); System.out.println();
    }
}
