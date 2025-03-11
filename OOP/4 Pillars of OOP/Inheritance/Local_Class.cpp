#include <iostream>
using namespace std;

void processOrder() {
    class LocalClass { // Local Class inside a function
    public:
        void show() {
            cout << "Processing Order..." << endl;
        }
    };

    LocalClass obj;
    obj.show();
}

int main() {
    processOrder();
    return 0;
}
