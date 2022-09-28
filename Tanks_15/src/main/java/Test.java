public class Test {
    public static void main(String[] args) {
        //1) Перевести заданные строки в массивы чисел
        int H1 = 3; //число строк первого массива
        int W1 = 4; //число столбцов первого массива
        String S1 = "1234 2345 0987"; //задание строки для первого массива

        int H2 = 2; //число строк второго массива
        int W2 = 2; //число столбцов второго массива
        String S2 = "34 98"; //задание строки для второго массива

        //нам нужен отдельный метод по переводу строк в массив
        int[][] arr1 = Methods.StrToArr(H1, W1, S1);
        int[][] arr2 = Methods.StrToArr(H2, W2, S2);
        //а еще нам нужен метод по тестовому выводу массива
        Methods.ArrShow(arr1);
        System.out.println();
        Methods.ArrShow(arr2);


    }
}
