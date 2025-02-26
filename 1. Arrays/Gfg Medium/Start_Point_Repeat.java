import java.util.Scanner;

public class Start_Point_Repeat {
    public static void main(String[] args) {
        int[] arr = {6, 10, 5, 4, 9, 120, 4, 6, 10};
        int size = arr.length;
        int element = -1;
        
        for(int i=0; i<size; i++)
        {
            for(int j=i+1; j<size; j++)
            {
                if(arr[i] == arr[j])
                {
                    element = arr[i];
                    break;
                }
            }
                if (element != -1) { 
                break;
            }
        }
        System.out.println(element);
    }
}
