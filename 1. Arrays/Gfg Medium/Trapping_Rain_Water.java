public class  Trapping_Rain_Water {

    public static int trap(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j+1])
                {
                    int element1 = arr[i] - arr[j];
                    sum += element1;
                }else{
                    j++; // move pointer to next towards 
                    int element2 = arr[j+1] - arr[j];
                    sum += element2; 
                }
            }
            break;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Total Water is " + trap(a));
    }
}
