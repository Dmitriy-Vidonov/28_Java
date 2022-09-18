public class Test {
    public static void main(String[] args) {
        double diag = (float) Math.sqrt(2); //расчет диагонали - 1.41..
        //double sum = diag * 2 + 7; //число-сумма например 9.828427
        double sum = 0;
        //(int)Math.round(sum * 100000) - мы результат с кучей знаков умнож. на 100000 - чтобы знаки убрать
        //Math.round() - округлили полученный ранее результат
        //Integer.toString - перевели в строку число. .replace - сделали замену.

        sum=0;
        int[] hits = {1,2,3,4,5,6,2,7,8,9};
        for(int i=0; i<hits.length-1; i++) {
            switch (hits[i]) {
                case 1:
                    switch (hits[i+1]) {
                        case 6, 2, 9:
                          sum++;
                          break;
                        case 5, 8:
                          sum+=diag;
                          break;
                        default: sum+=0;
                    } break;
                case 2:
                    switch (hits[i+1]) {
                        case 1, 3, 5, 8:
                           sum++;
                           break;
                        case 6, 9, 7, 4:
                           sum+=diag;
                           break;
                        default: sum+=0;
                    } break;
                case 3:
                    switch (hits[i+1]) {
                        case 4, 2, 7:
                            sum++;
                            break;
                        case 5, 8:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 4:
                    switch (hits[i+1]) {
                        case 5, 3:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 5:
                    switch (hits[i+1]) {
                        case 6, 4, 2:
                            sum++;
                            break;
                        case 1, 3:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 6:
                    switch (hits[i+1]) {
                        case 1, 5:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 7:
                    switch (hits[i+1]) {
                        case 8, 3:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 8:
                    switch (hits[i+1]) {
                        case 9, 7, 2:
                            sum++;
                            break;
                        case 1, 3:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } break;
                case 9:
                    switch (hits[i+1]) {
                        case 1, 8:
                            sum++;
                            break;
                        case 2:
                            sum+=diag;
                            break;
                        default: sum+=0;
                    } default: sum+=0;
            }
        }
        int res = Integer.parseInt(Integer.toString((int)Math.round(sum * 100000))
                .replace("0", "")); //перевод в нужный формат 9.828427 -> 982843

        System.out.println(Integer.toString(res));

        //ПРОВЕРКА
        int[] hits1 = {1,2,3,4,5,6,2,7,8,9};
        System.out.println("строка - " + Level1.PatternUnlock(10, hits1));
    }
}
