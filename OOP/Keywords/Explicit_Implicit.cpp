#include <iostream>
using namespace std;

class Test {
public:
    explicit Test(int x) {  // ?? Now this is an explicit constructor
        cout << "Constructor called with value: " << x << endl;
    }
};

int main() {
    Test obj = 10;  // ? ERROR: Implicit conversion not allowed due to `explicit`
    Test obj(10);  // ? Direct initialization (allowed)
    return 0;
}
