#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int prev;
    cin >> prev;
    
    long long sum = 0; 

    for (int i = 1; i < n; i++) {  
        int current;
        cin >> current;
        if (prev > current) {
            sum += (prev - current);
        } else {
            prev = current;
        }
    }
    
    cout << sum;
    return 0;
}
