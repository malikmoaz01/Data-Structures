public class Doubly {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public Doubly() {
        this.head = null;
    }

    // Insert at head
    public void insertAtHead(int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        if (head != null) {
            head.prev = newnode;
        }
        head = newnode;
    }

    // Insert At Last 
    public void insertAttail(int data )
    {
        if(head == null)
        {
            insertAtHead(data);
        }
        Node newnode = new Node(data);
        Node current = head ;
        while(current.next != null)
        {
            current = current.next;
        }
        current.next = newnode ;
        newnode.next = null;
        newnode.prev = current;
    }
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.err.println("Position should be positive");
            return;
        }
        if (position == 1) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.err.println("Position is beyond the current length of the list");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;
        if(current.next != null)
        {
            current.prev.next = newNode;
        }
        current.next = newNode;
    }

    // Delete At Head 
    void deleteNodeAtHead()
    {
        if(head == null)
        {
            System.out.println("No Node in Linked List");
            return ;
        }
        head = head.next;
        head.prev = null;
    }
    // Delete At Tail
    void deleteNodeAtLast()
    {
        if(head == null)
        {
            System.out.println("No Elements in LL \n");
            return ;
        }
        if(head.next == null)
        {
            deleteNodeAtHead();
            return;
        }
        Node lastnode = head ;
        while(lastnode.next.next != null)
        {
            lastnode = lastnode.next;  
        }
        lastnode.next = null;
    }
    
    public void deleteAtPosition(int position) {
        if (head == null || position <= 0) {
            System.out.println("Invalid position or empty list.");
            return;
        }
    
        // Delete head
        if (position == 1) {
            deleteNodeAtHead();
            return;
        }
    
        Node temp = head;
        int count = 1;

        while (temp != null && count < position) {
            temp = temp.next;
            count++;
        }
    
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
    
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    
        temp.prev = null;
        temp.next = null;
    }
    
    // Print function
    void print() {
        if (head == null) {
            System.out.println("No Node in LL");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Doubly list = new Doubly();
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAttail(6);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAttail(7);
        list.deleteNodeAtHead();
        list.deleteNodeAtLast();
        list.print();  
    }
}
