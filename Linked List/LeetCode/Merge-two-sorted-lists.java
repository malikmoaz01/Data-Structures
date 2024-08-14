// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-1);
        ListNode demo = temp;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                demo.next = list2;
                list2 = list2.next;
            } else {
                demo.next = list1;
                list1 = list1.next;
            }
            demo = demo.next;
        }
        if (list1 == null) {
            demo.next = list2;
        }
        if (list2 == null) {
            demo.next = list1;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        Solution sol = new Solution();
        ListNode mergedList = sol.mergeTwoLists(list1, list2);

        printList(mergedList);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
