import java.util.*;

public class FractionalKP {
    public static void main(String[] args) {
        double capacity = 20.0;

        double[][] items = {
            {10.0, 100.0},
            {5.0, 70.0},
            {15.0, 90.0}
        };

        List<double[]> valueToWeightRatios = new ArrayList<>();
        for (double[] item : items) {
            double weight = item[0];
            double value = item[1];
            double ratio = value / weight;
            valueToWeightRatios.add(new double[]{weight, value, ratio});
        }

        valueToWeightRatios.sort((a, b) -> Double.compare(b[2], a[2]));

        double total = 0.0 ;
        double remain_capacity = capacity;

        for(double[] vwr : valueToWeightRatios)
        {
            double weight = vwr[0];
            double value = vwr[1];
            double ratio = vwr[2];

            if(remain_capacity >=  weight)
            {
                total += value;
                remain_capacity -= weight;
            }else {
                total += remain_capacity * ratio;
                remain_capacity = 0;
                break; 
            }
        }
        System.out.println(total);
        
    }
}
