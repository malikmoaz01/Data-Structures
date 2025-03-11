#include <iostream>
using namespace std;

// Base Class
class Car {
public:
    // Virtual Function for Runtime Polymorphism
    virtual void engineSound() {
        cout << "Car makes a generic engine sound!" << endl;
    }
};

// Derived Class 1 - Sports Car
class SportsCar : public Car {
public:
    void engineSound() override {
        cout << "SportsCar: VROOOOM! ??" << endl;
    }
};

// Derived Class 2 - Electric Car
class ElectricCar : public Car {
public:
    void engineSound() override {
        cout << "ElectricCar: Whirrrrr... ?" << endl;
    }
};

// Derived Class 3 - Truck
class Truck : public Car {
public:
    void engineSound() override {
        cout << "Truck: RUMMMMBLE! ??" << endl;
    }
};

int main() {
    // Base Class Pointer
    Car* car1;
    
    // Sports Car Object
    SportsCar ferrari;
    car1 = &ferrari;
    car1->engineSound();  // Output: SportsCar: VROOOOM! ??

    // Electric Car Object
    ElectricCar tesla;
    car1 = &tesla;
    car1->engineSound();  // Output: ElectricCar: Whirrrrr... ?

    // Truck Object
    Truck volvo;
    car1 = &volvo;
    car1->engineSound();  // Output: Truck: RUMMMMBLE! ??

    return 0;
}
