#include <iostream>
#define max 1000
using namespace std;

class Stack {
public:
    int top;
    int arr[max];

    Stack() {
        top = -1;
    }

    bool push(int x) {
        if (top >= max - 1) {
            cout << "Stack Overflow \n";
            return false;
        }
        else {
            arr[++top] = x;
            cout << x << " pushed into stack\n";
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            cout << "Stack Underflow \n";
            return -1;
        }
        else {
            int x = arr[top--];
            cout << x << " popped out\n";
            return x;
        }
    }

    int peek() {
        if (top < 0) {
            cout << "Stack is empty\n";
            return -1;
        }
        return arr[top];
    }

    bool isEmpty() {
        return (top < 0);
    }

    int size() {
        return (top + 1); 
    }
};

int main() {
    Stack s;
    s.push(10);
    s.push(20);
    s.push(30);

    cout << "Stack size is: " << s.size() << endl;

    s.pop();
    s.pop();

    cout << "Stack size is: " << s.size() << endl;

    s.pop();
    if (s.isEmpty())
        cout << "Stack is empty\n";
    else
        cout << "Stack is not empty\n";

    return 0;
}
