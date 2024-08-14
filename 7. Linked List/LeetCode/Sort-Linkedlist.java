public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Find the middle of the list
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves
        
        // Step 2: Recursively sort the two halves
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);
        
        // Step 3: Merge the sorted halves
        ListNode sortedList = merge(left, right);
        
        return sortedList;
    }
    
    // Helper function to find the middle of the list
    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    // Helper function to merge two sorted lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // Connect the remaining nodes
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution sol = new Solution();
        ListNode result = sol.sortList(node1);

        ListNode current = result;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Output should be 1 2 3 4
    }
}
