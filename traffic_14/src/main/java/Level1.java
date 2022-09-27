import java.util.*;

public class Level1 {
    public static int Unmanned(int L, int N, int[][] track) {
        int time, odometer, path, red, green, result, wait;
        time = odometer = result = wait = 0;
        boolean activeLight = true;
        if(N == 0) {
            time = L;
        } else {
            for(int i=0; i<N; i++) {
                path = track[i][0];
                red = track[i][1];
                green = track[i][2];
                odometer += (path - odometer);
                result = (odometer+time) - ((red + green) * ((odometer+time) / (red + green)));
                wait = 0;
                if(result > red) {
                    activeLight = false;
                } else {
                    wait = red - result;
                }
                if(wait > 0) time += wait;

                if(i == N-1) {
                    time += L;
                }
            }
        }
        return time;
    }
}
