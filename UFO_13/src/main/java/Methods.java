public class Methods {
    public static int[] numToArr(int number) { //метод для перевода числа в массив чисел
        int res = number;
        int divider = 1;
        int count = 0;

        do { //если разряд 1, условие while не выполнится, а цикл хотя бы 1 раз провести надо
            res = number / divider;
            divider *= 10; //с каждым шагом повышаем делитель на 1 порядок
            count++;
        } while (res >= 10);

        //создаем массив по числу разрядов
        int[] numArray = new int[count];

        //заполнить массив цифрами числа
        int arrCount = 0; //переменная для хранения индекса элемента массива
        for (int i = count - 1; i >= 0; i--) { //в i у нас будет хранится разряд числа. Цикл от 2 до 0
            if (number > 10) { //пока не достигли младшего разряда числа
                numArray[arrCount] = (int) (number / Math.pow(10, i));
                number -= (int) (Math.pow(10, i) * numArray[arrCount]);
                arrCount++;
            } else numArray[arrCount] = number;
        }
        return numArray;
    }
    //тестируем метод numToArr
    /*public static void main(String[] args) {
        int number = 144;
        int[] array = numToArr(number);
        for (int nums : array) System.out.print(nums + " ");
    }*/

    public static int convert(int[] arr, int divider) { //метод для конвертации из N-ричной системы в 10-чную
        int res = 0;
        int arrCount = 0;
        for (int i = arr.length - 1; i >= 0; i--) { //i двигаем от 2 до 0, в итоге 3 шага, храним в i разряд
            res += arr[arrCount] * (int) Math.pow(divider, i);
            arrCount++;
        }
        return res;
    }

    //тестируем метод convert
    /*public static void main(String[] args) {
        int[] arr = {1, 4, 4};
        int divider = 8;
        System.out.println(convert(arr, divider));
    }*/
}
