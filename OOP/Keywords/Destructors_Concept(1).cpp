#include <iostream>
using namespace std;

class A {
public:
    A() {
        cout << "A Constructor Called" << endl;
    }
    
    ~A() {
        cout << "A Destructor Called" << endl;
    }
};

class B : public A {
public:
    B() {
        cout << "B Constructor Called" << endl;
    }

    ~B() {
        cout << "B Destructor Called" << endl;
    }
};

int main() {
    cout << "Creating Object obj:" << endl;
    B obj;
    cout << "Exiting main function" << endl;
    return 0;
}
