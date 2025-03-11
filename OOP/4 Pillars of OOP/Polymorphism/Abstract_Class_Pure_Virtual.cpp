#include <iostream>
using namespace std;

	class Car {
	public:
	    virtual void engineSound() = 0;  // ? Pure Virtual Function
	};
	
	class SportsCar : public Car {
	public:
	    void engineSound() override {
	        cout << "SportsCar: VROOOOM! ??" << endl;
	    }
	};

int main() {
    // Car obj; ? Error: Cannot create object of abstract class
    SportsCar obj;
    obj.engineSound();  // ? Allowed
    return 0;
}
