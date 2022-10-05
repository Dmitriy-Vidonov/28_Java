import java.lang.reflect.Array;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
       //System.out.println("Массив возрастающий? " + Methods.isArrayAscending(arr, 0));
       //System.out.println("Массив убывающий? " + Methods.isArrayDescending(arr, 0));

       //метод перестановки
       int startPoint = 0; //стартовая точка, от которой идет отсчет 3-х элементов массива
       int[] arrTest = {1,2,3,4,5,7,6};
      /* for(int i=startPoint; i<arrTest.length-2; i++) {
           System.out.println("Проверка на убывание при i:  " + i + " = " + Methods.isArrayDescending(arrTest, i));
           System.out.println("Проверка на возрастание при i:  " + i + " = " + Methods.isArrayAscending(arrTest, i));
           System.out.println("Проверка на готовность тройки:  " + i + " = " + Methods.isThisThreeOkay(arrTest, i));
       } */

        /*
       Methods.arrElementsMoveLeft(arrTest, startPoint);
       for(int nums : arrTest) System.out.print(nums + " ");
       System.out.println();
       Methods.arrElementsMoveLeft(arrTest, startPoint);
       for(int nums : arrTest) System.out.print(nums + " ");
       System.out.println();
       Methods.arrElementsMoveLeft(arrTest, startPoint);
       for(int nums : arrTest) System.out.print(nums + " ");
       System.out.println();
       Methods.arrElementsMoveLeft(arrTest, startPoint);
       for(int nums : arrTest) System.out.print(nums + " ");
       System.out.println();
*/
       //метод проверки - стоит ли вообще трогать 3 элемента?
       /*
        if (arrTest[startPoint] >= arrTest[startPoint + 2] && arrTest[startPoint] <= arrTest[startPoint + 1])
           System.out.println("Есть смысл перестановки");
       else System.out.println("Смысла в перестановке нет");
        */
       //А нафига нам вообще эти перестановки мутить, если проверка нам даст ответ по сути?
       //нам же проверку надо сделать, а не вернуть переставленные элементы
       //то есть по сути каждые тройки проверить на возможность перестановки и все!
       //если хоть в 1-й нельзя, значит и везде нельзя, сразу стопаем
       //нет смысла проверять тройку элементов на возрастание или убывание - сразу проверка на целесообразность перестановки

       int count = 0;
       //это неверный метод по итогу. и слишком долгий
       for(int i=0; i<arrTest.length-2; i++) {
           if ((!Methods.isArrayDescending(arrTest, i)
                   && Methods.isArrayAscending(arrTest, i)
                   && !Methods.isThisThreeOkay(arrTest, i))
                   ||
                   (!Methods.isArrayDescending(arrTest, i)
                           && !Methods.isArrayAscending(arrTest, i)
                           && Methods.isThisThreeOkay(arrTest, i))
                   ||
                   (!Methods.isArrayDescending(arrTest, i)
                           && !Methods.isArrayAscending(arrTest, i)
                           && !Methods.isThisThreeOkay(arrTest, i))) count++;
           else break;
       }
       if (count == arrTest.length-2) System.out.println("Преобразовать можно");
       else System.out.println("Преобразовать нельзя");
    }
}
