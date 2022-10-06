public class Level1 {
    public static boolean MisterRobot(int N, int[] data) {
        boolean flag = true;
        boolean res = false;
        mainloop: while (flag == true) {
            for(int i=0; i<data.length-2; i++) {
                if(isThreeArrAscending(data, i)) continue; //we continue if 3-digits is ascending
                else if (isThreeArrDescending(data, i)) break mainloop; //if 3-digits is descending, we stop all
                else if (isThisThreeOkay(data, i)) { //check for possibility to move digits if not both asc and desc
                    while(isThreeArrAscending(data, i) != true) { //moving digits until 3-digits arr will be asc
                        arrElementsMoveLeft(data, i);
                    }
                } else break mainloop; //if not any of options - stop all
            } if(isFullArrayAscending(data)) {res = true; break mainloop;}
            else flag = true;
        }
        return res;
    }

    //check if 3-digits array is ascending (from the certain point inside main array)
    public static boolean isThreeArrAscending(int[] arrAsc3, int startAsc3) {
        if(arrAsc3[startAsc3 + 2] >= arrAsc3[startAsc3 + 1]
                && arrAsc3[startAsc3 + 2] >= arrAsc3[startAsc3]
                && arrAsc3[startAsc3 + 1] >= arrAsc3[startAsc3]) return true;
        else return false;
    }

    //check if 3-digits array is descending (from the certain point inside main array)
    public static boolean isThreeArrDescending(int[] arrDesc3, int startDesc3) {
        if(arrDesc3[startDesc3 + 2] <= arrDesc3[startDesc3 + 1]
                && arrDesc3[startDesc3 + 2] <= arrDesc3[startDesc3]
                && arrDesc3[startDesc3 + 1] <= arrDesc3[startDesc3]) return true;
        else return false;
    }

    //check if the whole array is ascending
    public static boolean isFullArrayAscending(int[] arrAsc) {
        int countAsc = 0;
        boolean resAsc = true;
        for (int i = 0; i+1 < arrAsc.length; i++) {
            if (arrAsc[i+1] >= arrAsc[i]) {
                countAsc++;
            }
        }
        if ((countAsc != arrAsc.length-1)) return false;
        return resAsc;
    }

    //method for moving 3-digits array to the left (from the certain point of main array
    public static void arrElementsMoveLeft(int[] arrMove, int startPoint) {
        int buffer;
        buffer = arrMove[startPoint];
        arrMove[startPoint] = arrMove[startPoint + 2];
        arrMove[startPoint + 2] = buffer;

        buffer = arrMove[startPoint];
        arrMove[startPoint] = arrMove[startPoint + 1];
        arrMove[startPoint + 1] = buffer;
    }

    //is it make sense to remove elements in 3-digits array
    public static boolean isThisThreeOkay(int[] array, int startWith) {
        if (array[startWith] >= array[startWith + 2] && array[startWith] <= array[startWith + 1])
            return true;
        else return false;
    }
}
