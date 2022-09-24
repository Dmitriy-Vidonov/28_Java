import java.util.*;

public class Test {
    public static void main(String[] args) {
        /*дано: int num 144
        Задача: определить число разрядов у данного числа*/
        int num = 144;
        int count = 0;
        int divider = 1;
        int res = num;

        do { //если разряд 1, условие while не выполнится, а цикл хотя бы 1 раз провести надо
            res = num / divider;
            divider *= 10; //с каждым шагом повышаем делитель на 1 порядок
            count++;
        } while (res >= 10);
        //System.out.println("число разрядов числа " + num + " = " + count);

        //создаем массив по числу разрядов
        int[] numArray = new int[count];

        //заполнить массив цифрами числа
        int arrCount = 0; //переменная для хранения индекса элемента массива
        for(int i = count-1; i>=0; i--) { //в i у нас будет хранится разряд числа. Цикл от 2 до 0
            if(num > 10) { //пока не достигли младшего разряда числа
                numArray[arrCount] = (int) (num / Math.pow(10, i));
                num -= (int)(Math.pow(10, i) * numArray[arrCount]);
                arrCount++;
            } else numArray[arrCount] = num;
        }
        //Тестовый вывод итогового массива
        //for(int nums : numArray) System.out.print(nums + " "); System.out.println();

        //перевести полученный ранее восьмеричный массив в 10-ричную систему
        //этот же код потом преобразовать в метод convert
        res = 0;
        divider = 8; //основание системы счисления
        arrCount = 0;
        for(int i=numArray.length-1; i>=0; i--) { //i двигаем от 2 до 0, в итоге 3 шага, храним в i  разряд
            res += numArray[arrCount] * (int) Math.pow(divider, i);
            arrCount++;
        }
        //System.out.println("res = " + res); //тестовый вывод полученного числа в 10-й системе

        //дано: массив int[] arr = {1234, 1777} boolean octal = true (8-миричная система счисления)
        //Задача: перевести его в массив с 10-тиричными числами
        divider = 0;
        boolean octal = false;
        int buffer = 0;
        int[] arr = {1234, 1777};

        if (octal) {
            divider = 8;
        } else divider = 16;

        for(int i=0; i<arr.length; i++) {
            buffer = arr[i];
            //здесь нам нужен метод numToArr() для перевода числа в массив чисел
            int[] bufferArr = Methods.numToArr(buffer);
            buffer = Methods.convert(bufferArr, divider);
            arr[i] = buffer;
        }
        //Тестовый вывод итогового массива
        for (int nums : arr) System.out.print(nums + " ");
    }
}
