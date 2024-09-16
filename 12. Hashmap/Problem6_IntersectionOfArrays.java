import java.util.*;

public class Problem6_IntersectionOfArrays {

    static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for (int num : arr1) {
            set1.add(num);
        }
        
        for (int num : arr2) {
            if (!set1.contains(num)) {
                intersection.add(num);
            }
        }
        
        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 3, 4};
        
        Set<Integer> result = findIntersection(arr1, arr2);
        System.out.println(result);
    }
}
