public class Test {
    public static void main(String[] args){
    int[][] array = new int[3][3];
    array[0][0] = 4;
    array[0][1] = 8;
    array[0][2] = 7;
    array[1][0] = 6;
    array[1][1] = 7;
    array[1][2] = 5;
    array[2][0] = 3;
    array[2][1] = 2;
    array[2][2] = 6;

    int top = 0;
    int bottom = array.length-1;
    int left = 0;
    int right = array[0].length-1;
    int prev, curr;
    while (left < right && top < bottom) {
        prev = array[top+1][left];
        for(int i=left; i<right+1; i++) {
            curr = array[top][i];
            array[top][i] = prev;
            prev = curr;
        }
        top++;
        for(int i=top; i<bottom+1; i++) {
            curr = array[i][right];
            array[i][right] = prev;
            prev = curr;
        }
        right--;
        for(int i=right; i>left-1; i--) { //посмотреть - больше или меньше нужно
            curr=array[bottom][i];
            array[bottom][i] = prev;
            prev = curr;
        }
        bottom--;
        for(int i=bottom; i>top-1; i--) {
            curr = array[i][left];
            array[i][left] = prev;
            prev = curr;
        }
        left++;

    }

        for (int i=0; i<array.length; i++){
            System.out.println();
            for (int j=0; j< array[0].length; j++){
                System.out.print(array[i][j]);
            }
        }

   }
}
