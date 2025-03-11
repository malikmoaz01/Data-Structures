#include <iostream>
using namespace std;

class A {
protected:
    int x;

public:
    A() {
        x = 0;
        cout << "A Default Constructor Called" << endl;
    }

    A(int a) {
        x = a;
        cout << "A Parameterized Constructor Called" << endl;
    }

    A(const A &obj) {
        x = obj.x;
        cout << "A Copy Constructor Called" << endl;
    }

    ~A() {
        cout << "A Destructor Called" << endl;
    }

    void display() {
        cout << "x = " << x << endl;
    }
};

class B : public A {
private:
    int y;

public:
    B() : A() {
        y = 0;
        cout << "B Default Constructor Called" << endl;
    }

    B(int a, int b) : A(a) {
        y = b;
        cout << "B Parameterized Constructor Called" << endl;
    }

    B(const B &obj) : A(obj) {
        y = obj.y;
        cout << "B Copy Constructor Called" << endl;
    }

    ~B() {
        cout << "B Destructor Called" << endl;
    }

    void display() {
        cout << "x = " << x << ", y = " << y << endl;
    }
};

int main() {
    cout << "\nCreating obj1 (Default Constructor):" << endl;
    B obj1;
    obj1.display();

    cout << "\nCreating obj2 (Parameterized Constructor):" << endl;
    B obj2(10, 20);
    obj2.display();

    cout << "\nCreating obj3 (Copy Constructor):" << endl;
    B obj3 = obj2;
    obj3.display();

    cout << "\nExiting main function" << endl;
    return 0;
}
