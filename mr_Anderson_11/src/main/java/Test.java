import java.util.*;

public class Test {
    public static void main(String[] args) {
        String num1, num2;
        num1 = "0"; //первое число
        num2 = "0"; //второе число

        int len1, len2, countLen, countLetter;
        len1 = num1.length(); //длина первого числа
        len2 = num2.length(); //длина второго числа
        countLen = len1;
        countLetter = 0;

        //определение большего числа
        if(num1.length() > num2.length()){
            System.out.println("число " + num1 + " > числа " + num2);
        } else if (num1.length() == num2.length()) {
            while (countLen > 0) {
                if(Integer.valueOf(num1.charAt(countLetter)-'0') > Integer.valueOf(num2.charAt(countLetter)-'0')) {
                    System.out.println("число " + num1 + " > числа " + num2);
                    break;
                } else if (Integer.valueOf(num1.charAt(countLetter)-'0') < Integer.valueOf(num2.charAt(countLetter)-'0')) {
                    System.out.println("число " + num1 + " < числа " + num2);
                    //если num1 меньше, то надо поменять числа местами
                    String buffer = num1;
                    num1 = num2;
                    num2 = buffer;
                    break;
                } else {
                    countLen--;
                    countLetter++;
                }
            }
        } else {
            String buffer = num1;
            num1 = num2;
            num2 = buffer;
            System.out.println("число " + num1 + " < числа " + num2);
        }
        if(countLen == 0) {
            System.out.println("числа " + num1 + " и " + num2 + " - равны!");
        }

        //переопределяем длины для чисел
        len1 = num1.length();
        len2 = num2.length();

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

        //вывод первых двух строк для последующей проверки
        for(int i=0; i<2; i++) {
            for(int j=0; j<resArraLen; j++) {
                System.out.print(resArray[i][j] + " ");
            }
            System.out.println();
        }
        //вычитание столбиком из большего числа меньшее
        for(int i=resArraLen-1; i>=0; i--) {
            if(resArray[0][i] < resArray[1][i]) {
                resArray[2][i] = resArray[0][i] + 10 - resArray[1][i];
                resArray[0][i-1] -= 1;
            } else {
                resArray[2][i] = resArray[0][i] - resArray[1][i];
            }
        }

        //тестовый вывод последней строки
        for(int i=2; i<3; i++) {
            for(int j=0; j<resArraLen; j++) {
                System.out.print(resArray[i][j] + " ");
            }
            System.out.println();
        }

        //считываем результат
        String result = "";
        int i=0;
        while (resArray[2][i] == 0) {
            i++;
            break;
        }

        if(i==1) i = 0; //если всего один символ, то все равно нужна 1 итерация

        for(int j=i; j<resArraLen; j++) {
            result += resArray[2][j];
        }
        System.out.println("результат = " + result);
    }
}
