public class Test {
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

    public static void main(String[] args) {
        int N = 3; //длина обоих массивов
        int[] arrA = {50, 1, 1024}; //массив с ID сотрудников
        int[] arrF = {20000, 100000, 90000}; //массив с ЗП
        bubbleSort(arrA); //A1
        bubbleSort(arrF); //F
        //составляем итоговый массив с зависимостями ЗП от ID
        int[] arrC = new int[arrA.length + arrF.length];
        int indexA, indexF;
        indexA = indexF = 0;
        for(int i=0; i<arrC.length; i+=2) {
            arrC[i] = arrF[indexF];
            arrC[i+1] = arrA[indexA];
            indexA++;
            indexF++;
        }

        for(int i=0; i< arrA.length; i++) { //основной цикл по списку ID сотрудников
            int indexC=0;
            while(arrC[indexC] != arrA[0]) {
                indexC++;
            }

            indexF = 0;
            while(arrF[indexF] != arrC[indexC-1]) {
                indexF++;
            }

            int tempF = arrF[i];
            arrF[i] = arrF[indexF];
            arrF[indexF] = tempF;
        }
        //проверка полученного массива A
        for(int i=0; i<N; i++) {
            System.out.print(arrA[i] + " ");
        }
        System.out.println();
        //проверка полученного массива
        for(int i=0; i<N; i++) {
            System.out.print(arrF[i] + " ");
        }
    }
}
