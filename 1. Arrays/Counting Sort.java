import java.util.*;

class CountingSort {

    public void countSort(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int countarray[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            countarray[arr[i]]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (countarray[i] > 0) {
                arr[index] = i;
                index++;
                countarray[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        CountingSort cs = new CountingSort();
        cs.countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
