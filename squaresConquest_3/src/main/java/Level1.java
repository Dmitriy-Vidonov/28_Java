public class Level1 {
    public static int[] getConquer(int[][] map, int x, int y, int ignoreF, int mapRows, int mapCols) {

        int[] conquerArr = new int[10];
        int cellFill;
        int counter = 0;

        if (ignoreF == 1) cellFill = 2;
        else cellFill = 1;

        if (x + 1 <= mapRows - 1 && (map[x +1][y] == 0)) {
            conquerArr[0] = x + 1;
            conquerArr[1] = y;
            counter++;
        } else {
            conquerArr[0] = -1;
            conquerArr[1] = -1;
        }
        if (x - 1 >= 0 && (map[x -1][y] == 0)) {
            conquerArr[2] = x - 1;
            conquerArr[3] = y;
            counter++;
        } else {
            conquerArr[2] = -1;
            conquerArr[3] = -1;
        }
        if (y + 1 <= mapCols - 1 && (map[x][y +1] == 0)) {
            conquerArr[4] = x;
            conquerArr[5] = y + 1;
            counter++;
        } else {
            conquerArr[4] = -1;
            conquerArr[5] = -1;
        }
        if (y - 1 >= 0 && (map[x][y -1] == 0)) {
            conquerArr[6] = x;
            conquerArr[7] = y - 1;
            counter++;
        } else {
            conquerArr[6] = -1;
            conquerArr[7] = -1;
        }
        conquerArr[8] = cellFill;
        conquerArr[9] = counter;

        return conquerArr;
    }

    public static int ConquestCampaign(int N, int M, int L, int[] battalion){
        int days = 0;
        int countFull = 0;
        int ignFlag;
        int mapSquare = N*M;

        int[][] map = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                map[n][m] = 0;
            }
        }

        int count = 0;
        for(int i=0; i<L; i++) {
            if(map[battalion[count]-1][battalion[count+1]-1] == 0) {
                map[battalion[count]-1][battalion[count+1]-1] = 1;
                countFull++;
            }
            count+=2;
        }
        days++;

        if(countFull < mapSquare) {
            while (countFull < mapSquare) {
                days++;

                if(days % 2 == 0) {
                    ignFlag = 1;
                } else ignFlag = 2;

                for(int i=0; i<map.length; i++) {
                    for(int j=0; j<map[0].length; j++) {
                        if(map[i][j] == ignFlag) {

                            int[] arr = getConquer(map, i, j, ignFlag, map.length, map[0].length);
                            countFull += arr[9];

                            for(int k=0; k<arr.length-2; k+=2) {
                                if(arr[k] != -1) {
                                    map[arr[k]][arr[k+1]] = arr[8];
                                }
                            }
                        }
                    }
                }
            }
        } else {
            return days;
        }
        return days;
    }
}
