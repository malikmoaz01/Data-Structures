public class BrowserHistory {
    private class Node {
        String url;
        Node prev;
        Node next;
        
        Node(String url) {
            this.url = url;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node current;
    
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }
    
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("homepage.com");

        history.visit("page1.com");
        history.visit("page2.com");
        System.out.println(history.back(1)); // Output: "page1.com"
        System.out.println(history.forward(1)); // Output: "page2.com"
        history.visit("page3.com");
        System.out.println(history.forward(2)); // Output: "page3.com"
        System.out.println(history.back(3)); // Output: "homepage.com"
    }
}
