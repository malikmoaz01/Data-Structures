#include <iostream>
using namespace std;

class Queue {
private:
    int size;
    int rear;
    int *arr;

public:
    Queue(int size) {
        this->size = size;
        rear = -1;
        arr = new int[size];
    }

    ~Queue() {
        delete[] arr;
    }

    bool isEmpty() {
        return rear == -1;
    }

    bool isFull() {
        return (rear == size - 1);
    }

    void Enqueue(int x) {
        if (isFull()) {
            cout << "Queue Overflow\n";
            return;
        } else {
            rear++;
            arr[rear] = x;
        }
    }

    int Dequeue() {
        if (isEmpty()) {
            cout << "Queue Underflow \n";
            return 0;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }

    int peek() {
        if (isEmpty()) {
            cout << "Queue Underflow \n";
            return 0;
        }
        return arr[0];
    }
};

int main() {
    Queue q(5); // Initialize queue with size 5
    q.Enqueue(10);
    q.Enqueue(20);
    q.Dequeue();
    cout << "Is queue empty? " << (q.isEmpty() ? "Yes" : "No") << endl;
    cout << "Is queue full? " << (q.isFull() ? "Yes" : "No") << endl;
    q.Enqueue(30);

    return 0;
}
