public class Circular {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;

    public Circular() {
        this.head = null;
        this.tail = null;
    }

    public void insertAtHead(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
            newnode.next = head;
        } else {
            newnode.next = head;
            head = newnode;
            tail.next = head;
        }
    }

    void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            insertAtHead(data);
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    void insertAtTail(int data) {
        insertLast(data);
    }

    void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    void deleteAtHead() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    void deleteAtTail() {
        if (head == null) return;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
        }
    }

    public static void main(String[] args) {
        Circular cll = new Circular();
        cll.insertAtHead(10);
        cll.insertAtTail(20);
        cll.insertAtTail(30);
        cll.insertAtTail(40);
        cll.printList();
        cll.deleteAtTail();
        cll.printList();
        cll.deleteAtTail();
        cll.printList();
    }
}
