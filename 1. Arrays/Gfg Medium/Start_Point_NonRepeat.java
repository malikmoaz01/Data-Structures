import java.util.HashMap;
import java.util.Map;

public class Start_Point_NonRepeat {
    public static void main(String[] args) {
        int[] arr1 = {-1, 2, -1, 3, 0};
        int[] arr2 = {9, 4, 9, 6, 7, 4};

        System.out.println(findFirstNonRepeating(arr1));
        System.out.println(findFirstNonRepeating(arr2));
    }

    public static int findFirstNonRepeating(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (countMap.get(num) == 1) {
                return num;
            }
        }
        return Integer.MIN_VALUE;
    }
}
