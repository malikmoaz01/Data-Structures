import java.util.Arrays;

class Fibo_No_Tabulation {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int previous1 = dp[1];
        int previous2 = dp[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = previous1 + previous2;
            previous2 = previous1;
            previous1 = dp[i];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibo_No_Tabulation Fibo_No_Tabulation = new Fibo_No_Tabulation();
        int n = 10;
        System.out.println("Fibonacci number at position " + n + " is: " + Fibo_No_Tabulation.fib(n));
    }
}
