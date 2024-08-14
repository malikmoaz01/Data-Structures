public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            // Swap the nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move pointers for the next pair
            prev = first;
            head = first.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create linked list for testing
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Call the method and print the result
        Solution sol = new Solution();
        ListNode result = sol.swapPairs(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected output: 2 1 4 3
    }
}
