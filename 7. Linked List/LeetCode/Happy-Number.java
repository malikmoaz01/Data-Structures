class Solution {
    int findSquare(int n) {
        int n1 = 0;
        while (n != 0) {
            int rem = n % 10;
            n = n / 10;
            n1 += rem * rem;
        }
        return n1;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Is 19 a happy number? " + sol.isHappy(19)); // Should print true
        System.out.println("Is 2 a happy number? " + sol.isHappy(2)); // Should print false
    }
}
