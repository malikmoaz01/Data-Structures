#include<iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter the number of rows: ";
    cin >> n;
	cout<<"\n";
    for (int i = 1; i <= n; i++) {
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
