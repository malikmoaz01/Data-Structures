#include <iostream>
using namespace std;

class Base {
public:
    virtual void show() { cout << "Base class function\n"; }
};

class Derived : public Base {
public:
    void show() override { cout << "Derived class function\n"; }
};
class Derived1 : public Base {
public:
    void show() override { cout << "Derived1 class function\n"; }
};

int main() {
    Base* obj = new Derived1();
    obj->show(); // Derived class ka function call hoga
    delete obj;
    return 0;
}
