import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> charsTable = new HashMap<>();
        String[] str3 = {" ", "'", "`"}; //под каждый расход составить свой список
        for(String letter : str3) charsTable.put(letter, 3); //в цикле каждому элементу списка присвоить значение
        System.out.println(charsTable.get("1")); //вытаскиваем данные

        /*
        charsTable.put(" ", 0);
        charsTable.put("&", 24);
        charsTable.put(",", 7);
        charsTable.put("2", 22);
        charsTable.put("8", 23);
        charsTable.put(">", 10);
        charsTable.put("D", 26);
        charsTable.put("J", 18);
        charsTable.put("P", 23);
        charsTable.put("V", 19);
        charsTable.put("\\", 10);
        charsTable.put("b", 25);
        charsTable.put("h", 21);
        charsTable.put("n", 18);
        charsTable.put("t", 17);
        charsTable.put("z", 19);
        charsTable.put()*/
    }
}
