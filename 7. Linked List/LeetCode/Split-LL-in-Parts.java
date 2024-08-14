public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        
        int totalNodes = length / k;
        int extraNodes = length % k;
        
        ListNode[] result = new ListNode[k];
        current = head;
        
        for (int i = 0; i < k && current != null; i++) {
            result[i] = current;
            
            int partSize = totalNodes;
            if (i < extraNodes) {
                partSize++;
            }
            
            for (int j = 1; j < partSize; j++) {
                current = current.next;
            }
            
            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }
        
        return result;
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
        ListNode[] parts = sol.splitListToParts(head, 3);

        // Print the result
        for (int i = 0; i < parts.length; i++) {
            ListNode current = parts[i];
          
