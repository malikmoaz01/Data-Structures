#include <iostream>
using namespace std;

class Base {
public:
    int x = 10;
    void show() { cout << "Base class\n"; }
};

class Derived : public Base {
public:
    int y = 20;
    void show() { cout << "Derived class\n"; }
};

int main() {
    Derived d;
    Base b = d;  // ?? Object Slicing (Derived ka 'y' variable kho gaya)
    
    cout << b.x << endl;  // ? Accessible
    // cout << b.y;  // ? ERROR (y slice ho gaya)
    
    b.show();  // ? Base class ka show() chalega, Derived ka nahi
}
