public class Maximum_Product_Subarray {

    public static int maxProductSubArray(int[] a) {
        int max_so_far = a[0];
        int max_ending_here = a[0];
        int min_ending_here = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                int temp = max_ending_here;
                max_ending_here = min_ending_here;
                min_ending_here = temp;
            }

            max_ending_here = Math.max(a[i], max_ending_here * a[i]);
            min_ending_here = Math.min(a[i], min_ending_here * a[i]);

            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] a = {6, -3, -10, 0, 2};
        System.out.println("Maximum product subarray is " + maxProductSubArray(a));
    }
}
