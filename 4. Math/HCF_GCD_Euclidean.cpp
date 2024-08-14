#include <iostream>
using namespace std;
int gcd(int a, int b) {
    if (a == 0)
        return b;
    return gcd(b%a,a);
}

int main() {
    int a = 12; 
    int b = 15; 
    
    cout << "GCD of " << a << " and " << b << " is " << gcd(a, b) << endl;
    return 0;
}
