#include <iostream>
using namespace std;

class Test {
public:
    Test() { cout << "Constructor called!" << endl; }
};

int main() {
    Test* obj = new Test();  // ?? Object dynamically create kiya
    delete obj;  // ?? Heap memory free ki
    return 0;
}
