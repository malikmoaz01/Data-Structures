#include <iostream>
using namespace std;

class Engine {
public:
    void start() { cout << "Engine started\n"; }
};

class Car {
public:
    Engine* engine;  
    Car(Engine* e) { engine = e; }
    void drive() { engine->start(); }
};

int main() {
    Engine e;
    Car c(&e);
    c.drive();
}
