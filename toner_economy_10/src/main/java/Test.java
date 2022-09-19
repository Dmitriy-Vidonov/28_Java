import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> charsTable = new HashMap<>();
        //String[] str3 = {" ", "'", "`"}; //под каждый расход составить свой список
        //for(String letter : str3) charsTable.put(letter, 3); //в цикле каждому элементу списка присвоить значение
        //System.out.println(charsTable.get("1")); //вытаскиваем данные
        //Интересно будет сделать несколько реализаций данной задачи и потом тестами сравнить скорость выполнения

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
        charsTable.put("!", 9);
        charsTable.put("'", 3);
        charsTable.put("-", 7);
        charsTable.put("3", 23);
        charsTable.put("9", 26);
        charsTable.put("?", 15);
        charsTable.put("E", 26);
        charsTable.put("K", 21);
        charsTable.put("Q", 31);
        charsTable.put("W", 26);
        charsTable.put("]", 18);
        charsTable.put("c", 17);
        charsTable.put("i", 15);
        charsTable.put("o", 20);
        charsTable.put("u", 17);
        charsTable.put("{", 18);
        charsTable.put("\"", 6);
        charsTable.put("(", 12);
        charsTable.put(".", 4);
        charsTable.put("4", 21);
        charsTable.put(":", 8);
        charsTable.put("@", 32);
        charsTable.put("F", 20);
        charsTable.put("L", 16);
        charsTable.put("R", 28);
        charsTable.put("X", 18);
        charsTable.put("^", 7);
        charsTable.put("d", 25);
        charsTable.put("j", 20);
        charsTable.put("p", 25);
        charsTable.put("v", 13);
        charsTable.put("|", 12);
        charsTable.put("#", 24);
        charsTable.put(")", 12);
        charsTable.put("/", 10);
        charsTable.put("5", 27);
        charsTable.put(";", 11);
        charsTable.put("A", 24);
        charsTable.put("G", 25);
        charsTable.put("M", 28);
        charsTable.put("S", 25);
        charsTable.put("Y", 14);
        charsTable.put("_", 8);
        charsTable.put("e", 23);
        charsTable.put("k", 21);
        charsTable.put("q", 25);
        charsTable.put("w", 19);
        charsTable.put("}", 18);
        charsTable.put("$", 29);
        charsTable.put("*", 17);
        charsTable.put("0", 22);
        charsTable.put("6", 26);
        charsTable.put("<", 10);
        charsTable.put("B", 29);
        charsTable.put("H", 25);
        charsTable.put("N", 25);
        charsTable.put("T", 16);
        charsTable.put("Z", 22);
        charsTable.put("`", 3);
        charsTable.put("f", 18);
        charsTable.put("l", 16);
        charsTable.put("r", 13);
        charsTable.put("x", 13);
        charsTable.put("~", 9);
        charsTable.put("%", 22);
        charsTable.put("+", 13);
        charsTable.put("1", 19);
        charsTable.put("7", 16);
        charsTable.put("=", 14);
        charsTable.put("C", 20);
        charsTable.put("I", 18);
        charsTable.put("O", 26);
        charsTable.put("U", 23);
        charsTable.put("[", 18);
        charsTable.put("a", 23);
        charsTable.put("g", 30);
        charsTable.put("m", 22);
        charsTable.put("s", 21);
        charsTable.put("y", 24);

        String testStr = " ";
        char[] strArr = testStr.toCharArray();
        //Считываем по ключам все значения
        for(String k : charsTable.keySet()) {
            System.out.println("key:" + k + " value:" + charsTable.get(k));
        }
        
    }
}
