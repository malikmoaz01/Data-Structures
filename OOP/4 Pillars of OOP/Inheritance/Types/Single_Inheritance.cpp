#include <iostream>
using namespace std;

class Parent {
public:
    void show() { cout << "Parent class\n"; }
};

class Child : public Parent {
};

int main() {
    Child obj;
    obj.show();
}
