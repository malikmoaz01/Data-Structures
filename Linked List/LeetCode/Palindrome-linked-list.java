public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode current = slow;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        ListNode firstHalf = head;
        ListNode secHalf = prev;
        
        while (secHalf != null) {
            if (firstHalf.val != secHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secHalf = secHalf.next;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(2);
        ListNode nodeC = new ListNode(3);
        nodeA.next = nodeB;
        nodeB.next = nodeC;

        Solution sol = new Solution();
        System.out.println("Is list [1, 2, 2, 1] a palindrome? " + sol.isPalindrome(node1)); // Should print true
        System.out.println("Is list [1, 2, 3] a palindrome? " + sol.isPalindrome(nodeA)); // Should print false
    }
}
