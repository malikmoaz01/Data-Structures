import java.util.Arrays;

public class CarFuel {

    public static int minRefuelingStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        
        int[][] extendedStations = Arrays.copyOf(stations, n + 1);
        extendedStations[n] = new int[] {target, Integer.MAX_VALUE};
        
        int fuel = startFuel;
        int lastPos = 0;
        int stops = 0;
        
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        
        for (int i = 0; i <= n; i++) {
            int[] station = extendedStations[i];
            int distanceToStation = station[0] - lastPos;
            fuel -= distanceToStation;
            
            while (!maxHeap.isEmpty() && fuel < 0) {
                fuel += maxHeap.poll();
                stops++;
            }
            
            if (fuel < 0) {
                return -1;
            }
            
            maxHeap.add(station[1]);
            lastPos = station[0];
        }
        
        return stops;
    }

    public static void main(String[] args) {
        int target = 1000;
        int startFuel = 200;
        int[][] stations = {
            {200, 300},
            {400, 500},
            {600, 700},
            {800, 900}
        };
        
        System.out.println(minRefuelingStops(target, startFuel, stations));
    }
}
