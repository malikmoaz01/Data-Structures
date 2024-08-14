public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        
        ListNode startPosition = head;
        ListNode current = head;
        
        // Find the k-th node from the beginning
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
        startPosition = current;
        
        // Find the k-th node from the end
        ListNode endPosition = head;
        current = head;
        int steps = 0;
        
        while (current != null) {
            steps++;
            if (steps > k) {
                endPosition = endPosition.next;
            }
            current = current.next;
        }
        
        // Swap the values of the k-th node from the beginning and end
        int temp = startPosition.val;
        startPosition.val = endPosition.val;
        endPosition.val = temp;
        
        return head;
    }

    public static void main(String[] args) {
        // Create linked list for testing
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        Solution sol = new Solution();
        ListNode result = sol.swapNodes(head, 3);

        // Print the result
        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}


