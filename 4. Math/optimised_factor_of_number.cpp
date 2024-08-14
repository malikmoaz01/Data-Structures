#include <iostream>
#include <cmath>

using namespace std;

void printFactors(int number) {
    cout << "Factors of " << number << " are: ";
    for (int i = 1; i <= sqrt(number); ++i) {
        if (number % i == 0) {
            cout << i << " "; 
            if (i != number / i) {
                cout << number / i << " "; 
            }
        }
    }
    cout << endl;
}

int main() {
    int number = 28; 
    printFactors(number);
    return 0;
}
