import java.util.*;

public class Test {
    public static void main(String[] args) {
      int[] arr = {200, 350, 400, 150, 300, 250, 100};
      int buffer = 0;
      int index;
      int max;
     mainloop: for (int i=0; i<arr.length; i++) {
          for (int j=i; j<arr.length; j++) {
              max = Methods.MaxElement(arr, j); //max элемент ищем в ограниченном уже массиве
              buffer = arr[i];
              index = Methods.FindIndex(max, arr, j); //индекс максимального элемента
              arr[i] = max;
              arr[index] = buffer; //поменяли местами max и arr[i]
              continue mainloop;
          }
      }
      int sum = 0;
      for (int i=1; i<=arr.length; i++) {
          if (i % 3 == 0) {
              sum += arr[i-1];
          }
      }
      Methods.ShowArray(arr);
      System.out.println("Итоговая скидка - " + sum);
    }
}
