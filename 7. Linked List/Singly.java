public class Singly {

    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public Singly() {
        this.head = null;
    }
    // Insert At Haed 
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    // Print Function 
    public void print() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }
    // Insert At tail
    void insertAttail(int data){
        Node newnode = new Node(data);
        if(head == null)
        {
            head = newnode;
            return;
        }
        Node lastnode = head ;
        while(lastnode.next != null)
        {
            lastnode = lastnode.next;
        }
        lastnode.next = newnode ;
    }

    // Insert At Any Position 
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
        current.next = newNode;
    }

    // Delete Node At Head 
    void deleteNodeAtHead()
    {
        if(head == null)
        {
            System.out.println("No Node in Linked List");
            return ;
        }
        head = head.next;
    }
    // Delet Node At Last 
    void deleteNodeAtLast()
    {
        if(head == null)
        {
            System.out.println("No Elements in LL \n");
            return ;
        }
        if(head.next == null)
        {
            head.next = null;
            return;
        }
        Node lastnode = head ;
        while(lastnode.next.next != null)
        {
            lastnode = lastnode.next;  
        }
        lastnode.next = null;
    }
    // Delete At specific position 
    void deleteNodeAtPosition(int position)
    {
        if(head == null)
        {
            System.err.println("Linked List is Empty\n");
            return;
        }
        if(position < 1)
        {
            System.err.println("Position must be positive\n");
            return;
        }
        if(position == 1)
        {
            head = head.next;
            return; 
        }
        Node current = head ;
        int count = 1;
        while(current != null && count < position - 1 )
        {
            current = current.next;
            count++;
        }
        if (current == null || current.next == null) {
            System.out.println("Position is out of Bound\n");
            return;
        }
        current.next = current.next.next;
    }
    public static void main(String[] args) {
        Singly list = new Singly();
        
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.insertAttail(40);
        list.insertAttail(40);
        list.insertAtPosition(50, 4);
        // list.deleteNodeAtHead();
        // list.deleteNodeAtLast();
        list.deleteNodeAtPosition(3);
        list.print();  
    }
}
