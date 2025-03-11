#include <iostream>
using namespace std;

class Car {
public:
    class Engine { // Nested Class
    public:
        void start() {
            cout << "Engine Started!" << endl;
        }
    };
};

int main() {
    Car::Engine myEngine;
    myEngine.start();
    return 0;
}
