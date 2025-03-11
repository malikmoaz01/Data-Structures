#include <iostream>
using namespace std;

class Test {
private:
    int x;
public:
    Test(int x) {  // Constructor
        this->x = x;  // `this` ka use kar ke differentiate kiya
    }
    void show() {
        cout << "Value of x: " << this->x << endl;
    }
};

int main() {
    Test obj(10);  
    obj.show();  // ? Output: Value of x: 10
    return 0;
}
