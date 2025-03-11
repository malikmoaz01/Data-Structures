#include <iostream>
using namespace std;

class OperatorOverload {
public:
    int value;

    // Constructor
    OperatorOverload(int v) : value(v) {}

    // 1?? Overloading Arithmetic Operator (+)
    OperatorOverload operator+(const OperatorOverload &obj) {
        return OperatorOverload(value + obj.value);
    }

    // 2?? Overloading Relational Operator (==)
    bool operator==(const OperatorOverload &obj) {
        return value == obj.value;
    }

    // 3?? Overloading Logical Operator (!)
    bool operator!() {
        return value == 0;
    }

    // 4?? Overloading Bitwise Operator (&)
    OperatorOverload operator&(const OperatorOverload &obj) {
        return OperatorOverload(value & obj.value);
    }

    // Display Function
    void display() {
        cout << "Value: " << value << endl;
    }
};

int main() {
    OperatorOverload obj1(5), obj2(3), obj3(5);

    // Arithmetic Operator (+)
    OperatorOverload sum = obj1 + obj2;
    sum.display();  // Output: Value: 8

    // Relational Operator (==)
    cout << (obj1 == obj3) << endl;  // Output: 1 (true)
    cout << (obj1 == obj2) << endl;  // Output: 0 (false)

    // Logical Operator (!)
    cout << !obj1 << endl;  // Output: 0 (false)
    OperatorOverload obj4(0);
    cout << !obj4 << endl;  // Output: 1 (true)

    // Bitwise Operator (&)
    OperatorOverload bitwiseAnd = obj1 & obj2;
    bitwiseAnd.display();  // Output: Value: 1 (Binary: 101 & 011 = 001)

    return 0;
}
