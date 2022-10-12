public class Test {
    public static void main(String[] args) {
        Thread my_thread = Thread.currentThread();
        System.out.println("Текущий поток исполнения - " + my_thread);

        //изменить имя потока исполнения
        my_thread.setName("My_Threddo");
        System.out.println("Имя потока после изменения - " + my_thread);
        try {
            for(int n = 10; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("Главный поток исполнения прерван!");
        }
    }
}
