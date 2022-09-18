import java.util.ArrayList;

public class StringWork {
    public static void main(String[] args) {
        String s = "аллес гутте цем гебурстаг!";

      /*  int start = 2;
        int end = 7;
        System.out.println(s.substring(start, end));  // **лес г начали с 1 и закончили 5-м.

        String[] words = s.split(" ");

        System.out.println(s.substring(0, words[0].length())); //аллес*/

        int dlina = 8;
        //String[] spisok_strok = new String[dlina];
        ArrayList<String> spisok_strok = new ArrayList<>();

        int[] digits = new int[dlina];

        int counter = 0;
        while (counter < s.length()){
            if(s.length() <= dlina) {
                spisok_strok.add(s);
                //s = '';
            }

            counter++;
        }
    }
}