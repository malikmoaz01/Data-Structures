import java.util.HashSet;

public class Problem4_FindPairWithGivenSum {

    static boolean hasPairWithSum(int[] arr, int targetSum) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = targetSum - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int sum = 10;
        System.out.println(hasPairWithSum(arr, sum)); 
    }
}
