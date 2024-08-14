#include <iostream>
using namespace std;

int squareRoot(int n) {
    int start = 0, end = n;
    int result = 0;

    while (start <= end) {
        int mid = start + (end - start) / 2;
        int midSq = mid * mid;

        if (midSq == n) {
            return mid;  // Perfect square root found
        } else if (midSq < n) {
            start = mid + 1;
            result = mid; // Store closest integer value
        } else {
            end = mid - 1;
        }
    }

    return result;
}

int main() {
    int n = 40;
    cout << "Square root of " << n << " is: " << squareRoot(n) << endl;
    return 0;
}
