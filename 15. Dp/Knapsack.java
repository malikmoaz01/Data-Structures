public class Knapsack {

    static int[][] dp;

    public static int knapSack(int W, int[] weights, int[] values, int n) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (weights[n - 1] > W) {
            dp[n][W] = knapSack(W, weights, values, n - 1);
        } else {
            dp[n][W] = Math.max(
                values[n - 1] + knapSack(W - weights[n - 1], weights, values, n - 1),
                knapSack(W, weights, values, n - 1)
            );
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;

        dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        int maxValue = knapSack(W, weights, values, n);
        System.out.println("Maximum value in knapsack: " + maxValue);
    }
}
