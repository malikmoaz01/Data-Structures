import java.util.HashSet;

public class Problem2_Count_distinct_Element {

    int countdistinct(int arr[], int key) {
        HashSet<Integer> hashmap = new HashSet<>();
        for (int num : arr) {
            hashmap.add(num);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (hashmap.contains(key)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Problem2_Count_distinct_Element obj = new Problem2_Count_distinct_Element();
        int arr[] = {1, 2, 3, 2, 1, 4};
        int key = 2;
        System.out.println(obj.countdistinct(arr, key));
    }
}
