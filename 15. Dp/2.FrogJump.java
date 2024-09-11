import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int index, int[] stoneArr, int[] dp) {
        if (index == 0) return 0;

        if (dp[index] != -1) return dp[index];

        int left = frogJump(index - 1, stoneArr, dp) + Math.abs(stoneArr[index] - stoneArr[index - 1]);

        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = frogJump(index - 2, stoneArr, dp) + Math.abs(stoneArr[index] - stoneArr[index - 2]);
        }

        dp[index] = Math.min(left, right);

        return dp[index];
    }

    public static void main(String[] args) {
        int[] stoneArr = {10, 30, 40, 20};
        int n = stoneArr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int result = frogJump(n - 1, stoneArr, dp);
        System.out.println("Minimum cost: " + result);
    }
}
