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

        int[] arrA1 = arrA.clone(); //clone() нужен для полноценного копирования - вспомогат. массив для arrC
        int[] arrF1 = arrF.clone(); //clone() нужен для полноценного копирования - вспомогат. массив для arrC
        bubbleSort(arrA1);
        bubbleSort(arrF1);

        //составляем итоговый массив с зависимостями ЗП от ID
        int[] arrC = new int[arrA1.length + arrF1.length];
        int indexA, indexF;
        indexA = indexF = 0;
        for(int i=0; i<arrC.length; i+=2) {
            arrC[i] = arrF1[indexF];
            arrC[i+1] = arrA1[indexA];
            indexA++;
            indexF++;
        }

        System.out.println("массив зависимостей: ");
        for(int count : arrC) System.out.print(count + " ");
        System.out.println();

        //пройдем одну итерацию
        int iteration = 0;

        indexA=0;
        for(int i=0; i<arrC.length; i++) {
            if(arrC[i] == arrA[0]) {
                indexA = i;
            }
        }
        System.out.println("indexA = " + indexA);
        System.out.println("index A salary - " + arrC[indexA-1]);

        indexF=0;
        for(int i=0; i<arrF.length; i++) {
            if(arrF[i] == arrC[indexA-1]) {
                indexF=i;
            }
        }

        System.out.println("indexF = " + indexF);

        int tempF = arrF[iteration];
        arrF[iteration] = arrF[indexF];
        arrF[indexF] = tempF;

        System.out.println("arrF после смены элементов:");
        for(int count : arrF) System.out.print(count + " "); System.out.println();
     
    }
}
