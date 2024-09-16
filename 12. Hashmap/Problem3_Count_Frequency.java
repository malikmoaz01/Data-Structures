import java.util.*;

public class Problem3_Count_Frequency {

    HashMap<Integer, Integer> countFrequency(int arr[]) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String args[]) {
        Problem3_Count_Frequency obj = new Problem3_Count_Frequency();
        int arr[] = {1, 2, 3, 2, 1, 4};

        HashMap<Integer, Integer> result = obj.countFrequency(arr);
        System.out.println(result); 
    }
}
