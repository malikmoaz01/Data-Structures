public class Maximum_SubArray_Sum {

    public static int maxSubArraySum(int[] a) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int i = 0; i < a.length; i++) {
            max_ending_here += a[i];

            max_so_far = Math.max(max_so_far, max_ending_here);

            max_ending_here = Math.max(max_ending_here, 0);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum subarray sum is " + maxSubArraySum(a));
    }
}
