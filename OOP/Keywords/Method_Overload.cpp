#include <iostream>
using namespace std;
// Output decide huti ha compile time pr zarori nhi output same hu params different bs function name same ha 
class Math {
public:
    void add(int a, int b) { cout << "Sum: " << a + b << endl; }
    void add(double a, double b) { cout << "Sum: " << a + b << endl; }
    void add(int a, int b, int c) { cout << "Sum: " << a + b + c << endl; }
};

int main() {
    Math obj;
    obj.add(5, 10);       // int version
    obj.add(3.5, 2.1);    // double version
    obj.add(1, 2, 3);     // 3-parameter version
    return 0;
}
