public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int start = 0;
        int end = s.length() - 1;
        
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        String test = "A man, a plan, a canal: Panama";
        System.out.println(sol.isPalindrome(test)); 
    }
}
