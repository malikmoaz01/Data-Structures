#include <iostream>
using namespace std;

double squareRoot(int n, double precision) {
    double start = 0, end = n;
    double mid;

    while ((end - start) > precision) {
        mid = start + (end - start) / 2;
        if (mid * mid == n) {
            return mid;
        } else if (mid * mid < n) {
            start = mid;
        } else {
            end = mid;
        }
    }

    return mid;
}

int main() {
    int n = 40;
    double precision = 0.0001;
    cout << "Square root of " << n << " is: " << squareRoot(n, precision) << endl;
    return 0;
}
