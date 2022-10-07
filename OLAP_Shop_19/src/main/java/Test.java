import java.util.*;

public class Test {
    public static void main(String[] args) {
        //1) Создать sorted map и проверить - как оно сортирует ключи
        Map<String, Integer> testMap = new TreeMap<String, Integer>(); //создаем сортированную мапу для наших значений
        //добавляем в мапу значения
        testMap.put("платье1", 6);
        testMap.put("сумка32", 2);
        testMap.put("сумка23", 2);
        testMap.put("сумка128",4);

        //Вывод элементов мапы
        for (Map.Entry<String, Integer> testEntry : testMap.entrySet()) {
            System.out.println(testEntry.getKey() + " >>> " + testEntry.getValue());
        } System.out.println();

        //2) взять начальный массив, каждый элемент разбить на товар и число
        //2.1) товары поместить в sorted map как ключи, продажи - как значения. Делать проверку на дубли и "склеивать"
        String[] testStr = {"платье1 5", "сумка32 2", "платье1 1", "сумка23 2", "сумка128 4"}; //начальный массив строк
        Map<String, Integer> testMap2 = new TreeMap<String, Integer>();
        int buffer = 0;
        //вывести сначала составные части элементов массива - отдельно товары и продажи
        for(int i=0; i<testStr.length; i++) { //цикл по всему массиву строк, для каждого элемента
            //как там сплитить строки? И как перевести в Integer строку?
            String[] strElement = testStr[i].split(" ");
            System.out.println(strElement[0]+ " " + Integer.parseInt(strElement[1]));
             //заносим элементы в мапу
            //внедрить проверку - если такое значение ключа уже было - суммировать значения
            if(testMap2.containsKey(strElement[0])) { //если такой ключ есть в мапе
                buffer = testMap2.get(strElement[0]); //то получаем значение для этого ключа
                testMap2.put(strElement[0], (Integer.parseInt(strElement[1]) + buffer));
            } else testMap2.put(strElement[0], Integer.parseInt(strElement[1]));

        } System.out.println();

        for (Map.Entry<String, Integer> testEntry2 : testMap2.entrySet()) {
            System.out.println(testEntry2.getKey() + " --> " + testEntry2.getValue());
        } System.out.println();

        //Полученную мапу надо перевести в строку
        String resultStr = testMap2.toString(); //создали строку для вывода
        //System.out.println("resultStr = " + resultStr);

        resultStr = resultStr.replaceAll("[{}]", ""); //убрали фигурные скобки
        resultStr = resultStr.replaceAll("=", " "); //убрали знаки =
        System.out.println("resultStr after regexp = " + resultStr);

        String[] resArray = resultStr.split(", ");

        for(String word : resArray) System.out.print(word + ",");
    }
}
/*
 public static void main(String[] args) {
        String[] arrayTest = {"платье1 5", "сумка32 2", "платье1 1", "сумка23 2", "сумка128 4"};
        String[] resArr = ShopOLAP(5, arrayTest);
        for(String word : resArr) System.out.print(word + ",");
    }
*/