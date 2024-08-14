class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums , 0 , nums.length -  1);
        return nums;
    }
    void quickSort(int[] nums , int low , int high )
    {
        if(low < high )
        {
            int pivot = partition(nums , low , high );
            quickSort(nums , low , pivot - 1);
            quickSort(nums , pivot + 1 , high);
        }
    }
    int partition(int[] nums , int low , int high)
    {
        int pivot = nums[high];
        int i = low - 1;
        for(int j=low; j<high; j++)
        {
            if(nums[j] < pivot )
            {
                i++ ;
                swap(nums , i , j);
            }
        }
        swap(nums , i+1 , high);
        return i+1;
    } 
    void swap(int[] arr , int low , int high  )
    {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] =  temp ;
    }
}