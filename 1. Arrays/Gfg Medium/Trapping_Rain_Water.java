public class Trapping_rain_Water {

    public static int Trapping_rain_Waterr(int[] a) {
        int sum = 0;
        for(int i=0; i<a.length; i++)
        {
            for(int j=i+1; j<a.length; j++)
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
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 1, 0, 4, 0, 2};
        System.out.println("Total Water is " + Trapping_rain_Waterr(a));
    }
}
