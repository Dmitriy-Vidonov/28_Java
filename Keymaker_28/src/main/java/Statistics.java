public class Statistics {
    public static void main(String[] args) {
        for (int k = 1; k <= 50; k++) {
            Keymaker_for_stats.KeymakerForStats(k);
            System.out.println(Level1.Keymaker(k));
        }
    }
}