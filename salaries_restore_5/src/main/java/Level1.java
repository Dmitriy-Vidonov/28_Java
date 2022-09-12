public class Level1 {
    public static int[] SynchronizingTables(int N, int[] ids, int[] salary) {

        int[] arrA1 = ids.clone();
        int[] arrF1 = salary.clone();
        bubbleSort(arrA1);
        bubbleSort(arrF1);

        int[] arrC = new int[arrA1.length + arrF1.length];
        int indexA, indexF;
        indexA = indexF = 0;
        for (int i = 0; i < arrC.length; i += 2) {
            arrC[i] = arrF1[indexF];
            arrC[i + 1] = arrA1[indexA];
            indexA++;
            indexF++;
        }

        int iteration;
        for (iteration = 0; iteration < N; iteration++) {
            for (int i = 0; i < arrC.length; i++) {
                if (arrC[i] == ids[iteration]) {
                    indexA = i;
                }
            }

            for (int i = 0; i < salary.length; i++) {
                if (salary[i] == arrC[indexA - 1]) {
                    indexF = i;
                }
            }

            int tempF = salary[iteration];
            salary[iteration] = salary[indexF];
            salary[indexF] = tempF;

        }
        return salary;
    }
    public static void bubbleSort(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}