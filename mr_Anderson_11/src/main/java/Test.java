import java.util.*;

public class Test {
    public static void main(String[] args) {
        String num1, num2;
        num1 = "13459687489"; //первое число
        num2 = "145694856"; //второе число

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

        /*
        //тестовый вывод обоих массивов
        for (int num : num1Array) System.out.print(num + " ");
        System.out.println();
        for (int num : num2Array) System.out.print(num + " ");
        System.out.println();*/

        //занесение цифр 1-ого массива в итоговый
        int countNum1 = len1-1;
        for(int i=resArraLen-1; i>=resArraLen-len1; i--) {
            resArray[0][i] = num1Array[countNum1];
            countNum1--;
        }
        //занесение цифр 2-ого массива в итоговый
        int countNum2 = len2-1;
        for(int i=resArraLen-1; i>=resArraLen-len2; i--) {
            resArray[1][i] = num2Array[countNum2];
            countNum2--;
        }

        //тестовый вывод результирующего массива
        for(int i=0; i<3; i++) {
            for(int j=0; j<resArraLen; j++) {
                System.out.print(resArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
