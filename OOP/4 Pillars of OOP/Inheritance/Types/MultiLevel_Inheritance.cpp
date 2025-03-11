#include <iostream>
using namespace std;

class GrandParent {
public:
    void showG() { cout << "GrandParent class\n"; }
};

class Parent : public GrandParent {
public:
    void showP() { cout << "Parent class\n"; }
};

class Child : public Parent {
};

int main() {
    Child obj;
    obj.showG();
    obj.showP();
}
