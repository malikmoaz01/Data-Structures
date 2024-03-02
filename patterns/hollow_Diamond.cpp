#include<iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter the number of rows: ";
    cin >> n;
	cout<<"\n";
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i + j == n + 1) {
                cout << "*";
            } else if(i == n) {
                cout <<" ";
            }
            else {
                cout << " ";
            }
        }
        for (int j = 2; j <= n; j++) {
            if (i == j ) {
                cout << "*";
            } else {
                cout << " ";
            }
        }
        cout << "\n";
    }
    
    // Lower Part
    
    for (int i = n-1; i >= 1; i--) {
        for (int j = 1; j <= n; j++) {
            if (i == n || i + j == n + 1) {
                cout << "*";
            } else {
                cout << " ";
            }
        }
        for (int j = 2; j <= n; j++) {
            if (i == j || i == n) {
                cout << "*";
            } else {
                cout << " ";
            }
        }
        cout << "\n";
    }

    return 0;
}
