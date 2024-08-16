import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') 
                stack.push(')'); 
            else if (c == '{') 
                stack.push('}');
            else if (c == '[') 
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "{{[[(())]]}}";
        String test4 = "";

        System.out.println("Test 1: " + sol.isValid(test1)); 
        System.out.println("Test 2: " + sol.isValid(test2)); 
        System.out.println("Test 3: " + sol.isValid(test3)); 
        System.out.println("Test 4: " + sol.isValid(test4)); 
    }
}
