#include <iostream>
using namespace std;

class Car {
public:
    virtual ~Car() = 0;  // ? Pure Virtual Destructor

    void show() {
        cout << "Car class function" << endl;
    }
};

// ? Pure Virtual Destructor ki body dena zaroori hai
Car::~Car() {
    cout << "Car Destructor called!" << endl;
}

class SportsCar : public Car {
public:
    ~SportsCar() {
        cout << "SportsCar Destructor called!" << endl;
    }
};

int main() {
    Car* obj = new SportsCar();
    delete obj;  // ? Calls both destructors
    return 0;
}
