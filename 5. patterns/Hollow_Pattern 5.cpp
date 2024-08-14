#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    for (int row = 0; row < n; row++) {
        // Print spaces
        for (int col = 0; col < n - row - 1; col++) {
            cout << " ";
        }
        // Print stars
        for (int col = 0; col <= row; col++) {
            cout << "*";
        }
        for(int col = 1; col <= row; col++)
        {
        	cout<< "*";
		}
		cout<<"\n";
    }

    return 0;
}
