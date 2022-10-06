public class Test {
    public static void main(String[] args) {
      //  int[] arrTest = {5,6,2};
      /*  if(arrTest[2] >= arrTest[1] && arrTest[2] >= arrTest[0] && arrTest[1] >= arrTest[0]) System.out
                .println("Тройка чисел отсортирована по возрастанию");
        else if(arrTest[2] <= arrTest[1] && arrTest[2] <= arrTest[0] && arrTest[1] <= arrTest[0]) System.out
                .println("Тройка чисел отсортирована по убыванию");
        else System.out.println("Тройка чисел не сортирована ни так ни так"); */
      /*  if(Methods.isThreeArrAscending(arrTest, 0)) System.out.println("Тройка чисел отсортирована по возрастанию");
        else if(Methods.isThreeArrDescending(arrTest, 0)) System.out.println("Тройка чисел отсортирована по убыванию");
        else System.out.println("Тройка чисел не сортирована ни так ни так"); */

        //возможно сделать while с проверкой некоего флага, который будет известен после всего цикла. А потом повторить если что
        int startPoint = 0; //стартовая точка, от которой идет отсчет 3-х элементов массива
        //int[] arrTest = {1,3,4,5,6,2,7}; //все проходит
        int[] arrTest = {1,2,4,3};
        boolean flag = true;
        int count = 0;

        mainloop: while (flag == true) {
            for(int i=startPoint; i<arrTest.length-2; i++) {
               if(Methods.isThreeArrAscending(arrTest, i)) continue; //если тройка по возрастанию - продолжаем
               else if (Methods.isThreeArrDescending(arrTest, i)) break mainloop; //если тройка по убыванию - стопаем все
               else if (Methods.isThisThreeOkay(arrTest, i)) { //если не по возрастанию и  не по убыванию - проверить на возможность перестановки
                   //нужен цикл, в котором будем после перестановки проверять - по возрастанию получилось или еще нет
                   while(Methods.isThreeArrAscending(arrTest, i) != true) { //ВНИМАТЕЛЬНО ПРОСТЕСТИРОВАТЬ НА РАЗНЫХ ДАННЫХ
                       Methods.arrElementsMoveLeft(arrTest, i);
                   }
               } else break mainloop; //если не то и не другое и не третье - все тормозим
            } if(Methods.isFullArrayAscending(arrTest)) break mainloop;
            else flag = true;
        }
        System.out.println("Итоговый массив:");
        for(int nums : arrTest) System.out.print(nums + " "); System.out.println();
    }
}
/*
   //method check
    public static void main(String[] args) {
        int[] arrtest = {1,3,4,5,6,2,7};
        System.out.println(Mr_Robot(arrtest));
    }
 */
