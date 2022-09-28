public class Test_break_w_label_inner_loops_out {
    public static void main(String[] args) {
        outer: for (int i=0; i<3; i++) {
            System.out.print("Проход " + i + ": ");
                for (int j=0; j<100; j++) {
                    if (j == 10) {
                        //выйти можно ТОЛЬКО из блока, внутри которого есть break
                        break outer; //выход из обоих циклов. Как бы меткой указываем - что завершить
                    }
                    System.out.print(j + " ");
                }
                System.out.println("Эта строка не будет выводиться");
        }
        System.out.println("Циклы завершены");
    }
}
