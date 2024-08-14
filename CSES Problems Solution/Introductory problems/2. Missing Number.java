import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = n - 1;
        long total = 0, sum1 = 0;

        for (int i = 0; i < p; i++) {
            total = scanner.nextLong();
            sum1 += total;
        }

        long sum = (long) n * (n + 1) / 2;
        System.out.println(sum - sum1);

        scanner.close();
    }
}
