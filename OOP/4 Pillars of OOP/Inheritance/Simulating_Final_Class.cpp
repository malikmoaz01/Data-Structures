#include <iostream>
using namespace std;

class FinalClass {
private:
    FinalClass() { cout << "Final Class Constructor\n"; } // Private Constructor

public:
    static FinalClass create() { return FinalClass(); } // Factory Method
};

int main() {
    FinalClass obj = FinalClass::create(); // Object Creation via Static Method
    return 0;
}
