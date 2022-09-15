import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        String stroka = "аллеунде цум гебурстаг";
        int len = 11;

        //перевод строки в массив строк
        String[] words = stroka.split(" ");

        //каждое слово переведем в массив символов. на выходе получим - массив массивов
        char[][] massivSlov = new char[words.length][];
        for(int i=0; i<words.length; i++) {
            massivSlov[i] = words[i].toCharArray();
        }
        for(char[] rows : massivSlov) System.out.println(rows);

        ArrayList<char[]> matrix = new ArrayList<>();
        for(int i=0; i< massivSlov.length; i++)
        matrix.add(massivSlov[i]);

        char space = ' ';
        System.out.println(matrix.indexOf(6));

        //System.out.println("массив лист");
        //for(char[] mass : matrix) System.out.println(mass);


    }
}
