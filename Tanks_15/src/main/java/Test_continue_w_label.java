public class Test_continue_w_label {
    public static void main(String[] args) {
        outer: for (int i=0; i<10; i++) { //внешний цикл от 0 до 9
                for (int j=0; j<10; j++) { //внутренний цикл от 0 до 9
                    if (j > i) { //если шаг внутреннего цикла больше шага внешнего
                        System.out.println(); //переходим на новую строку
                        continue outer; //принудительно начинаем следующий шаг внешнего цикла, без вывода
                    }
                    System.out.print(" " + (i * j)); //выводим умножение внешнего цикла на внутренний
            }
        }
        System.out.println();
    }
}
