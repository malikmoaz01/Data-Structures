import java.util.Scanner;

public class rotate {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int size = array.length;
        int rotate = array[size-1];
        for(int i = size - 1; i>=1; i--)
        {
            array[i] = array[i-1];
        }
        array[0] = rotate;
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
