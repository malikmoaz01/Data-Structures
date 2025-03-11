#include <iostream>
using namespace std;

class Vehicle {
public:
    void move() { cout << "Vehicle is moving\n"; }
};

class Car : public Vehicle {
public:
    void drive() { cout << "Car is driving\n"; }
};

class Bike : public Vehicle {
public:
    void ride() { cout << "Bike is riding\n"; }
};

int main() {
    Car c;
    c.move();
    c.drive();

    Bike b;
    b.move();
    b.ride();
}
