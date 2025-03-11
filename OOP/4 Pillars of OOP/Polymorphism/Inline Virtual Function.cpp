#include <iostream>
using namespace std;

class Car {
public:
    virtual void engineSound() {  // ? Virtual functions are not inlined!
        cout << "Car makes a generic engine sound!" << endl;
    }
};

class SportsCar : public Car {
public:
    void engineSound() override {
        cout << "SportsCar: VROOOOM! ??" << endl;
    }
};

int main() {
    Car *ptr;
    SportsCar obj;
    ptr.engineSound();
}
