#include <iostream>
using namespace std;

class Engine {
public:
    void show() {
        cout << "Engine of Car" << endl;
    }
};

class PetrolCar : virtual public Engine {};
class DieselCar : virtual public Engine {};

class HybridCar : public PetrolCar, public DieselCar {};

int main() {
    HybridCar obj;
    obj.show();  // ? No ambiguity, because of virtual inheritance
    return 0;
}
