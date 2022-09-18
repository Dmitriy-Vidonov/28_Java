public class Level1 {
    public static int SumOfThe(int N, int[] data){
        int res=0;
        for(int i=0; i<N; i++) {
            res+=data[i];
        }
        return res/2;
    }
}
