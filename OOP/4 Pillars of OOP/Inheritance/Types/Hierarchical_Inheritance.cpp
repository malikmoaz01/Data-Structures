#include <iostream>
using namespace std;

class Parent {
public:
    void show() { cout << "Parent class\n"; }
};

class Child1 : public Parent {
};

class Child2 : public Parent {
};

int main() {
    Child1 obj1;
    Child2 obj2;
    obj1.show();
    obj2.show();
}
