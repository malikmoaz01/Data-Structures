// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {
        this.val = 0;
        this.next = null;
    }
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;  // Agar list khali hai, to null return karo
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;  // Duplicate ko skip karo
            } else {
                current = current.next;  // Next node pe move karo
            }
        }
        
        return head;
    }

    public static void main(String[] args) {
        // Example list create karna
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        // Solution object create karna aur method call karna
        Solution sol = new Solution();
        head = sol.deleteDuplicates(head);

        // Result print karna
        printList(head);
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
