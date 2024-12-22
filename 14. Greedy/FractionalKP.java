public class FractionalKP {
    public static void main(String[] args) {
        double capacity = 20.0;
        double[][] items = {
            {10.0, 100.0}, 
            {5.0, 70.0},   
            {15.0, 90.0}   
        };
        System.out.println("Knapsack Capacity: " + capacity);
        System.out.println("Items (weight, value):");
        for (double[] item : items) {
            System.out.println("Weight: " + item[0] + ", Value: " + item[1]);
        }
    }
}
