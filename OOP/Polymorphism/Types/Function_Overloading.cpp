#include <iostream>
using namespace std;

class Math {
public:
    // Function with 2 integer parameters
    int add(int a, int b) {
        return a + b;
    }

    // Function with 3 integer parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // Function with 2 double parameters
    double add(double a, double b) {
        return a + b;
    }
};

int main() {
    Math obj;
    cout << obj.add(5, 10) << endl;       // Calls int version
    cout << obj.add(5, 10, 15) << endl;   // Calls 3-int version
    cout << obj.add(5.5, 10.2) << endl;   // Calls double version
    return 0;
}
