import java.util.*;

public class PriorityQueue<T extends Comparable<T>> {

    private ArrayList<T> list;

    public PriorityQueue() {
        list = new ArrayList<>();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int start, int end) {
        T temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }

        T root = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return root;
    }

    private void downheap(int index) {
        int left = left(index);
        int right = right(index);
        int smallest = index;

        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            downheap(smallest);
        }
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty.");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ArrayList<T> heapSort() {
        ArrayList<T> sortedData = new ArrayList<>();
        while (!list.isEmpty()) {
            sortedData.add(this.remove());
        }
        return sortedData;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(10);
        pq.insert(5);
        pq.insert(15);
        pq.insert(2);

        try {
            System.out.println("Peek: " + pq.peek());
            System.out.println("Removed: " + pq.remove());
            System.out.println("Removed: " + pq.remove());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Integer> sortedData = pq.heapSort();
        System.out.println("Sorted Data: " + sortedData);
    }
}
