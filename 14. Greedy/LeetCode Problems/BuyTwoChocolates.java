import java.util.Arrays;

public class BuyTwoChocolates {
    
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        if (prices.length < 2) {
            return money;
        }

        int totalCost = prices[0] + prices[1];

        if (money >= totalCost) {
            return money - totalCost;
        } else {
            return money;
        }
    }
     
    public static void main(String[] args) {
        BuyTwoChocolates obj = new BuyTwoChocolates();
        int[] prices = {5, 3, 8, 6};
        int money = 10;
        
        int remainingMoney = obj.buyChoco(prices, money);
        System.out.println("Remaining money: " + remainingMoney);
    }
}
