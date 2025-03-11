#include <iostream>
using namespace std;

class Math {
public:
    inline int add(int a, int b) {
        return a + b;
    }
};

int main() {
    Math m;
    cout << "Sum: " << m.add(5, 10) << endl;
    return 0;
}
