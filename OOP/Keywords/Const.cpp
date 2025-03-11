#include <iostream>
using namespace std;

int main() {
    const int x = 10;
    // x = 20;  ? ERROR: Can't modify a `const` variable
    cout << "Value of x: " << x << endl;
    return 0;
}
