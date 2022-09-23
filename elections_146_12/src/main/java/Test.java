import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] arr = {60, 10, 10, 15, 5};

        //1) найти max элемент
        float maxElem = arr[0];
        for(int i=0; i<arr.length-1; i++) {
            if(maxElem < arr[i]) {
                maxElem = arr[i];
            }
        }
        //2) подсчет числа голосов
        //2.1) найти общую сумму
        float sum = 0;
        for(int num : arr) sum += num; //sum = 100
        //2.2) какой % от суммы составляет maxElem?
        float percentage = ((maxElem / sum) * 100);
        //System.out.printf("%.3f",percentage);

        //3) вычислим номер кандидата
        int index = 0;
        int isDouble = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == maxElem) {
                isDouble++; //считаем число дублей
            }
        }

        for (index=0; index<arr.length; index++) {
            if (arr[index] == maxElem) break; //получаем индекс победителя
        }
        index++; //приводим номер индекса к нормальному виду (не с 0)

        String resultString = "";
        if(isDouble > 1) {
            resultString = "no winner"; //необходимость перевыборов
        } else {
            if(percentage > 50) {
                resultString = ("majority winner " + index);
            } else {
                resultString = ("minority winner " + index);
            }
        }
        System.out.println(resultString);
    }
}
