import java.util.Arrays;

class Fibo_No_Memoization {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Fibo_No_Memoization Fibo_No_Memoization = new Fibo_No_Memoization();
        int n = 10; 
        System.out.println("Fibonacci number at position " + n + " is: " + Fibo_No_Memoization.fib(n));
    }
}
