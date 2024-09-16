import java.util.HashSet;

public class Problem5_CheckSubarrayWithZeroSum {

    static boolean hasSubarrayWithZeroSum(int[] arr) {
        HashSet<Integer> prefixSums = new HashSet<>();
        int currentSum = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum == 0 || prefixSums.contains(currentSum)) {
                return true;
            }

            prefixSums.add(currentSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, 3, 1};
        System.out.println(hasSubarrayWithZeroSum(arr)); 
    }
}
