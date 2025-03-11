#include <iostream>
using namespace std;

class Example {
private:
    int x;

public:
    Example() {
        x = 0;
        cout << "Default Constructor Called" << endl;
    }

    Example(int a) {
        x = a;
        cout << "Parameterized Constructor Called" << endl;
    }

    Example(const Example &obj) {
        x = obj.x;
        cout << "Copy Constructor Called" << endl;
    }

    ~Example() {
        cout << "Destructor Called" << endl;
    }

    void display() {
        cout << "x = " << x << endl;
    }
};

int main() {
    Example obj1;
    obj1.display();

    Example obj2(10);
    obj2.display();

    Example obj3 = obj2;
    obj3.display();

    return 0;
}
