public class Test {
    public static void main(String[] args) {
        int[] arr = {100, -50, 10, -25, 90, -35, 90};
        int sum=0;
        for(int i=0; i<arr.length; i++) {
            sum+=arr[i];
        }
        int res = sum/2;

        System.out.println("Результат = " + res);
        System.out.println(Level1.SumOfThe(arr.length, arr));
    }
}
