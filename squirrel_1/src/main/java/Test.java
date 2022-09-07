import java.util.*;

public class Test {
    public static void main(String[] args) { //int до до 2147483647 - до 10 разрядов
        int N = 10;
        int fact = 1;
        for(int i=1; i<=N; i++) {
            fact *= i;
        }
        System.out.println("факториал от " + N + " = " + fact); //3_628_800

       /* int res = fact;  КАК НАЙТИ ПЕРВОЕ ЧИСЛО ЧЕРЕЗ ARRAYLIST
        ArrayList<Integer> arr = new ArrayList<>();
        while (fact/10 > 0) {
            arr.add(fact % 10);
            fact /= 10;
        }
        arr.add(fact);
        System.out.println("fact[] " + Arrays.asList(arr));
        System.out.println("последняя цифра от " + fact + " = " + arr.get(arr.size()-1)); */

        //находим число разрядов в факториале
        int NFact = fact; //для подсчета первого числа в факториале
        int count = 1;
        int res2 = fact / 10;
        while(res2 > 0) {
            count++;
            res2 /= 10;
            NFact /= 10;
        }
        System.out.println("число разрядов в " + fact + " = " + count);
        System.out.println("перв. цифра от " + fact + " = " + NFact);

        //Найти первую цифру в числе


        /* ПОДРОБНО - КАКИМ МЕТОДОМ ИЩЕТСЯ ЧИСЛО РАЗРЯДОВ
        int num1 = 1_234_798;
        int res = num1 / 10;
        System.out.println(res); //123479
        res /= 10;
        System.out.println(res); //12347
        res /= 10;
        System.out.println(res); //1234
        res /= 10;
        System.out.println(res); //123
        res /= 10;
        System.out.println(res); //12
        res /= 10;
        System.out.println(res); //1
        res /= 10;
        System.out.println(res); //0 */

        //Вызов метода из Level1
        System.out.println("при числе " + N + " метод = " + Level1.squirrel(N));
    }
}
