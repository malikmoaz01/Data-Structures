#include <iostream>
#include <cmath>
using namespace std;

double newtonSqrt(double number, double precision) {
    if (number < 0) {
        throw invalid_argument("Cannot compute the square root of a negative number.");
    }

    double guess = number;
    while ((guess * guess - number) > precision) {
        guess = (guess + number / guess) / 2;
    }

    return guess;
}

int main() {
    double number = 25; 
    double precision = 1e-6; 
    double sqrt = newtonSqrt(number, precision);
    cout << "Square root of " << number << " is approximately " << sqrt << endl;
    return 0;
}
