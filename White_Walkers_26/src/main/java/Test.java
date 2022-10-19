import java.util.*;

public class Test {
    public static void main(String[] args) {
        //String village = "aaS=8";
        String village = "9===1===9===1===9";
        //String village = "9===1===9===1===9";
        int startNum = -1; //первое число в паре цифр
        int endNum = -1; //второй число в паре цифр
        int count = 0; //счетчик для прохода по строке
        List<Integer> pairs = new ArrayList<>(); //список для сумм на основе пар чисел
        List<Integer> equals = new ArrayList<>(); //список для сумм знаков =
        boolean startNumInstall = false; //флаг установки первого числа в паре
        boolean endNumInstall = false; //флаг установки второго числа в паре
        int sum = -1; //сумма для пары чисел
        int equalsCount = 0; //число знаков =
        int startIndex = 0;
        int endIndex = 0;
        //проход по всем
        mainloop: while (count < village.length()) { //проходим по каждому элементу строки
            //встречаем первую цифру - если символ строки это цифра и оба флажка не установлены
            if (Character.isDigit(village.charAt(count)) && startNumInstall == false && endNumInstall == false) {
                startNum = village.charAt(count) - '0';
                startNumInstall = true;
                startIndex = count;
                sum = -1;
            }
            //встречаем вторую цифру для пары - если символ строки это цифра и установлен флажок только нач. числа
            else if (Character.isDigit(village.charAt(count)) && startNumInstall == true && endNumInstall == false) {
                endNum = village.charAt(count) - '0';
                endNumInstall = true;
                endIndex = count;
                sum = startNum + endNum;
            }
            //встречаем вторую и больше пару цифр - когда встречаем цифру и оба флажка уже стоят
            else if (Character.isDigit(village.charAt(count)) && startNumInstall == true && endNumInstall == true) {
                startNum = endNum;
                startIndex = endIndex;
                endNum = village.charAt(count) - '0';
                endIndex = count;
                sum = startNum + endNum;
            }

            if(sum == 10) {
                pairs.add(sum); //добавляем сумму лишь в случае равенства 10
                equals.add(Methods.EqualsCount(village, startIndex, endIndex)); //считаем число = в поддиапазоне
            }
            sum = -1; //обнуляем сумму
            count++; //обновляем счетчик
        }

        if (pairs.size() > 0 && Methods.isOnlyOneDigit(equals, 3)) {
            System.out.println("все гуд");
        } else System.out.println("не гуд");

        for(int nums : pairs) System.out.print(nums + " "); System.out.println();
        for(int nums : equals) System.out.print(nums + " "); System.out.println();

        //проанализировать 2 списка - в одном все пары должны быть по 10
        //в другом должны быть только 3-ки
        List<Integer> listTest = new ArrayList<>();
        System.out.println("размер нулевого списка = " + listTest.size());
    }
}
