import java.util.Arrays;

public class AppleDistribution {
    
    public int minimumBoxes(int[] apple, int[] capacity) {
        int no_boxes = 0;
        int total_apples = Arrays.stream(apple).sum();
        Arrays.sort(capacity);

        int i = capacity.length - 1;
        while (i >= 0) {
            total_apples -= capacity[i];
            no_boxes++;
            if (total_apples <= 0)
                break;
            i--;
        }

        return no_boxes;
    }

    public static void main(String[] args) {
        AppleDistribution obj = new AppleDistribution();
        int[] apple = {5, 3, 8, 6};
        int[] capacity = {10, 8, 5, 7};
        
        int result = obj.minimumBoxes(apple, capacity);
        System.out.println("Minimum number of boxes required: " + result);
    }
}
