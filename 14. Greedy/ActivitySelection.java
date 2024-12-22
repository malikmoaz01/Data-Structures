public class ActivitySelection {

    static int[][] activities = {
        {1, 4},
        {3, 5},
        {0, 6},
        {5, 7},
        {8, 9},
        {5, 9}
    };

    public static void selectActivities() {
        java.util.Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));

        int lastFinishTime = activities[0][1];
        System.out.println("Selected Activity: " + "Start: " + activities[0][0] + " Finish: " + activities[0][1]);

        for (int i = 1; i < activities.length; i++) {
            if (activities[i][0] >= lastFinishTime) {
                System.out.println("Selected Activity: " + "Start: " + activities[i][0] + " Finish: " + activities[i][1]);
                lastFinishTime = activities[i][1];
            }
        }
    }

    public static void main(String[] args) {
        selectActivities();
    }
}
