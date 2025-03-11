#include <iostream>
using namespace std;

class Engine {
public:
    void start() { cout << "Engine started\n"; }
};

class Car {
private:
    Engine engine;  
public:
    void drive() { engine.start(); }
};

int main() {
    Car c;
    c.drive();
}
