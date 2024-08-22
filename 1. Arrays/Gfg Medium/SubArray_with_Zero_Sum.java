class Subarray_with_Zero_Sum {
    public static void main(String[] args) {
    int[] arr = {4, 2, -3, 1, 6};
    int size = arr.length;
    for(int i=0; i<size; i++)
    {
        int sum = arr[i];
        if(sum == 0)
        {
            System.out.println("true");
        }
        for(int j=i+1; j<size; j++)
        {
            sum += arr[j];
            if(sum == 0)
            {
                System.out.println("true");
                return;
            }
        }
    }
    System.out.println("false");
    }
}