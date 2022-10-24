public class Test_Inner_Loop {
    //Метод для смены состояния элемента
    public static void Change(boolean[] array, int i) {
        if(array[i] == true) {
            array[i] = false;
        } else array[i] = true;
    }

    //Метод для смены в массиве i-ого элемента на противоположный смена на каждый step-ный элемент
    public static void ReplaceEachStep(boolean[] arr, int step) {
        int i = 0;
        while (i < arr.length) {
            if (i + (step - 1) < arr.length) Change(arr, i += step - 1);
            i++;
        }
    }

    public static void main (String[] args) {
        int k = 15;
        boolean[] arr = new boolean[k];
        for (int i = 0; i < arr.length; i++) Test_right_approach.Change(arr, i);
        //Test_right_approach.ShowArr(arr);
        int step = 4;
        ReplaceEachStep(arr, step);

        Test_right_approach.ShowArr(arr);
    }
}
