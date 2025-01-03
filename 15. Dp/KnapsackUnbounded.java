public class KnapsackUnbounded {
    public int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
        int[] dp = new int[W + 1];
        
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        KnapsackUnbounded knapsack = new KnapsackUnbounded();
        int[] wt = {2, 3, 4, 5};
        int[] val = {3, 4, 5, 6};
        int W = 8;
        int n = wt.length;
        System.out.println(knapsack.unboundedKnapsack(W, wt, val, n));
    }
}
