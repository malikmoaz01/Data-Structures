#include <iostream>
using namespace std;

class Example {
private:
    int x, y;

public:
    Example() {
        x = 0;
        y = 0;
        cout << "Default Constructor Called!" << endl;
    }

    Example(int a, int b) {
        x = a;
        y = b;
        cout << "Parameterized Constructor Called!" << endl;
    }

    Example(const Example &obj) {
        x = obj.x;
        y = obj.y;
        cout << "Copy Constructor Called!" << endl;
    }

    void display() {
        cout << "x: " << x << ", y: " << y << endl;
    }
};

int main() {
    Example obj1;
    obj1.display();

    Example obj2(10, 20);
    obj2.display();

    Example obj3 = obj2;
    obj3.display();

    return 0;
}
