public class Count_SubArray_0_1 {

    public static int countSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0;
            int ones = 0;

            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }

                if (zeros == ones) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 1, 0, 1, 1};
        int[] arr2 = {1, 0, 0, 1, 1, 0, 0, 1};

        System.out.println(countSubarrays(arr1));  
    }
}
