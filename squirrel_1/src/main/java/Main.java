public class Main {
    public static int squirrel(int N) {
        int result = 0;
        return result;
    }

    public static void main(String[] args) {
       // try {
           /* int N1 = 19;

            //находим факториал
            int factorial = 1;
            for(int k=1; k<=N1; k++) {
                factorial *= k;
            }
            System.out.println("факториал " + N1 + " = " + factorial); //факториал находится корректно
*/
            //факториал с гита
            int N = 19;
            int factorial1 = 1;
            int count = 0;
            for(int i=2; i<N+1; i++) {
                factorial1 *= i;
            }

            System.out.println("factorial " + N + " (1) " + " = " + factorial1);

            N = factorial1;
            int firstDigit = factorial1;
            while (N > 0) {
                N = N / 10;
                count += 1;
            }

            for(int i=0; i<count-1; i++) {
                firstDigit /= 10;
            }

            System.out.println("функция - " + firstDigit);
/*
            //находим число разрядов в факториале
            int counter = 1;
            int razryad = 10;
            while((factorial / razryad) > 10) {
                razryad *= 10;
                counter++;
            }
            if(factorial < 10) {
                System.out.println("в " + factorial + " " + counter + " разрядов");
            } else System.out.println("в " + factorial + " " + (counter+1) + " разрядов");

            //находим первое число в факториале
            if(factorial < 10) System.out.println("1-е число в " + factorial + " = " + factorial);
            else System.out.println("1-е число в " + factorial + " = " + (factorial / razryad));
        } catch (Exception ex) {
            System.out.println("exception during squirell - " + ex);
        }
*/

        /*РЕШЕНИЕ ИЗ ГИТА*/

    }
}
