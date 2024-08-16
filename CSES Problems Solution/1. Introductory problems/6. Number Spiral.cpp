#include <iostream>
#include <vector>
using namespace std;

int main() {
    int t;
    cin >> t; 

    while (t--) {
        long long rows, cols;
        cin >> rows >> cols;

        long long zero_based_row = rows - 1;
        long long zero_based_col = cols - 1;

        vector<vector<long long>> arr = {
            {1, 2, 9, 10, 25},
            {4, 3, 8, 11, 24},
            {5, 6, 7, 12, 23},
            {16, 15, 14, 13, 22},
            {17, 18, 19, 20, 21}
        };

        if (zero_based_row < 5 && zero_based_col < 5) {
            cout << arr[zero_based_row][zero_based_col] << endl;
        } else {
            cout << "Invalid indices" << endl;
        }
    }

    return 0;
}
