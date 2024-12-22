// Problem Statement 

// You are given an array of integers t[], where each element represents the waiting time for a patient. 
// Your task is to arrange the patients in an order such that the total waiting time is minimized. 
// For example 
// [15,20,10], the optimal arrangement would be  [10,15,20]. In this order, 
// the total waiting time is  0+10+(10+15)=35, which is the minimum possible.


import java.util.Arrays;

public class Patient {
    public static void main(String[] args) {
        int[] arr_wait_time = {30, 20, 10, 60, 50, 40}; 
        
        Arrays.sort(arr_wait_time);
        
        int total_waiting_time = 0;
        int prefix_sum = 0;
        
        for (int i = 0; i < arr_wait_time.length; i++) {
            total_waiting_time += prefix_sum;
            prefix_sum += arr_wait_time[i];
        }
        
        System.out.println("Minimum Total Waiting Time: " + total_waiting_time);
    }
}
