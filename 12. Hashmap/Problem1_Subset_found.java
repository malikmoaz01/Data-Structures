import java.util.*;

public class Problem1_Subset_found {

    static boolean isSubset(int arr1[], int arr2[]) {
        HashSet<Integer> hashmap = new HashSet<>();
        for (int num : arr1) {
            hashmap.add(num);
        }
        for (int num : arr2) {
            if (!hashmap.contains(num)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int arr1[] = {11, 1, 13, 21, 3, 7};
        int arr2[] = {11, 3, 7, 1,21};

        if (isSubset(arr1, arr2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
