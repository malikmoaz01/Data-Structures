public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;

        while (listA != listB) {
            listA = (listA == null) ? headB : listA.next;
            listB = (listB == null) ? headA : listB.next;
        }

        return listA;
    }

    public static void main(String[] args) {
        // Create linked lists for testing
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        ListNode headB = new ListNode(99);
        headB.next = new ListNode(1);
        headB.next.next = common;

        Solution sol = new Solution();
        ListNode intersection = sol.getIntersectionNode(headA, headB);

        // Print the result
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
