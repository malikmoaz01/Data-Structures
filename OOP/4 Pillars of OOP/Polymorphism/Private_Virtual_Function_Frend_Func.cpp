#include <iostream>
using namespace std;

class Car {
private:
    virtual void engineSound() {  // ? Private Virtual Function
        cout << "Car makes a generic engine sound!" << endl;
    }
    friend class SportsCar;  // SportsCar can access private members
};

class SportsCar : public Car {
public:
    void engineSound() {  // ? Overrides Base Class function
        cout << "SportsCar: VROOOOM! ??" << endl;
    }

    void test() {
        engineSound();  // Allowed inside derived class
    }
};

int main() {
    SportsCar obj;
    obj.test();  // Calls overridden function
    return 0;
}
