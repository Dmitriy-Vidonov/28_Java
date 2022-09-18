public class Level1 {
    public static int ConquestCampaign(int N, int M, int L, int[] battalion){
        int days, countFull, ignFlag, mapSquare;
        days = 0;
        countFull = 0;
        mapSquare = N*M;

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

                            int mapRows = map.length;
                            int mapCols = map[0].length;
                            int[] conquerArr = new int[10];
                            int cellFill;
                            int counter = 0;

                            if (ignFlag == 1) cellFill = 2;
                            else cellFill = 1;

                            if (i + 1 <= mapRows - 1 && (map[i +1][j] == 0)) {
                                conquerArr[0] = i + 1; conquerArr[1] = j; counter++;
                            } else {
                                conquerArr[0] = -1; conquerArr[1] = -1;
                            }
                            if (i - 1 >= 0 && (map[i -1][j] == 0)) {
                                conquerArr[2] = i - 1; conquerArr[3] = j; counter++;
                            } else {
                                conquerArr[2] = -1; conquerArr[3] = -1;
                            }
                            if (j + 1 <= mapCols - 1 && (map[i][j +1] == 0)) {
                                conquerArr[4] = i; conquerArr[5] = j + 1; counter++;
                            } else {
                                conquerArr[4] = -1; conquerArr[5] = -1;
                            }
                            if (j - 1 >= 0 && (map[i][j -1] == 0)) {
                                conquerArr[6] = i; conquerArr[7] = j - 1; counter++;
                            } else {
                                conquerArr[6] = -1; conquerArr[7] = -1;
                            }
                            conquerArr[8] = cellFill; conquerArr[9] = counter;

                            countFull += conquerArr[9];

                            for(int k=0; k<conquerArr.length-2; k+=2) {
                                if(conquerArr[k] != -1) {
                                    map[conquerArr[k]][conquerArr[k+1]] = conquerArr[8];
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
