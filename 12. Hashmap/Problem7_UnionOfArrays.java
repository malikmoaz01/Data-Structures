import java.util.HashSet;
import java.util.Set;

public class Problem7_UnionOfArrays {

    static Set<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        
        for (int num : arr1) {
            union.add(num);
        }
        
        for (int num : arr2) {
            union.add(num);
        }
        
        return union;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 3, 4};
        
        Set<Integer> result = findUnion(arr1, arr2);
        System.out.println(result);
    }
}
