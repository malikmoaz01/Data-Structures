import java.util.ArrayList;

class Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap() {
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

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removed from an empty heap!");
        }

        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int left = left(index);
        int right = right(index);
        int min = index;

        if (left < list.size() && list.get(left).compareTo(list.get(min)) < 0) {
            min = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(min)) < 0) {
            min = right;
        }
        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

      public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
        data.add(this.remove());
        }
        return data;
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(2);

        try {
            System.out.println(heap.remove());
            System.out.println(heap.remove()); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
