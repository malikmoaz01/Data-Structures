#include <iostream>
using namespace std;

int sum(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return (n + sum(n-1)) ;
    }
}

int main() {
    int n = 5;
    cout << "Sum of " << n << " is: " << sum(n) << endl;
    return 0;
}
