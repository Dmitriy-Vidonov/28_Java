public class Test {
    public static void main(String[] args){
        //Итоговый черновой вариант
        int L, N, time, odometer, path, red, green, result, wait;
        int[][] track = {{3,5,5}, {5,2,2}};
        L = 10;
        N = 2;
        time = odometer = result = wait = 0;
        boolean activeLight = true;
        if(N == 0) { //в чистовике написать типа if(N == 0) return L;
            time = L; //время будет равно общему расстоянию
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
        System.out.println("Общее время = " + time);
    }
}
