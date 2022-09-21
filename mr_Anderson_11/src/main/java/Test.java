import java.util.*;

public class Test {
    public static void main(String[] args) {
        String num1, num2;
        num1 = "1605984590680"; //первое число
        num2 = "4509647986740869741"; //второе число

        int len1, len2;
        len1 = num1.length(); //длина первого числа
        len2 = num2.length(); //длина второго числа

        int[] num1Array = new int[len1]; //объявление массива для 1-ого числа
        int[] num2Array = new int[len2]; //объявление массива для 2-ого числа

        for(int i=0; i<len1; i++) { //заполняем массив num1Array
            num1Array[i] = Integer.valueOf(num1.charAt(i)-'0'); //каждый символ строки преобразуем в int для массива
        }

        for(int i=0; i<len2; i++) { //заполняем массив num2Array
            num2Array[i] = Integer.valueOf(num2.charAt(i)-'0'); //каждый символ строки преобразуем в int для массива
        }

        int resArraLen = len1;
        if(len2 > len1) resArraLen = len2; //вычисляем максимальную ширину итогового массива

        int[][] resArray = new int[3][resArraLen]; //задали массив для ответов

        /*тестовый вывод обоих массивов
        for (int num : num1Array) System.out.print(num + " ");
        System.out.println();
        for (int num : num2Array) System.out.print(num + " "); */
    }
}
