#include <iostream>
using namespace std;

class Base final { // `final` lagane se inheritance block ho gaya
public:
    void show() { cout << "Base class function\n"; }
};

// ? ERROR: Derived class cannot inherit from a `final` class
// class Derived : public Base { };

int main() {
    Base obj;
    obj.show();
    return 0;
}
