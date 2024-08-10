import java.util.HashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        ListNode current = head;
        boolean flag = false;
        int count = 0;
        
        while (current != null) {
            if (set.contains(current.val)) {
                if (!flag) {
                    count++;
                    flag = true;
                }
            } else {
                flag = false;
            }
            current = current.next;
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Create linked list for testing
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        
        // Define nums array
        int[] nums = {0, 1, 3, 4};
        
        // Call the method and print the result
        Solution sol = new Solution();
        int result = sol.numComponents(head, nums);
        System.out.println(result);  // Expected output: 2
    }
}
