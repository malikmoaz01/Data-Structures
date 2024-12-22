import java.util.Arrays;
import java.util.Collections;

public class CoinChange {
    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5};
        int target = 11;
        Arrays.sort(coins, Collections.reverseOrder());
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            while (target >= coins[i]) {
                target -= coins[i];
                count++;
            }
        }

        if (target != 0) {
            System.out.println("-1");
        } else {
            System.out.println(count);
        }
    }
}
