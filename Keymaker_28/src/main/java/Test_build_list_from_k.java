public class Test_build_list_from_k {
    public static void main(String[] args) {
        //берем длину, полученную из метода LenCount() из файла Test
        int k = 40;
        int len = Test.LenCount(k);
        int[] arr = new int[len];
        if(k >= 1 && k <= 3) arr[0] = 1;
        else if(k >= 4 && k <= 7) {
            arr[0] = 1;
            arr[1] = 4;
        } else {
            arr[0] = 1;
            arr[1] = 4;
        }
        int tmpCount = 3;
        for (int i = 2; i < len; i++) {
            if (tmpCount % 3 == 0) {
                arr[i] = arr[i - 1] + 4;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
            tmpCount++;
        }

        for(int nums : arr) System.out.print(nums + ", "); System.out.println();
    }
}
