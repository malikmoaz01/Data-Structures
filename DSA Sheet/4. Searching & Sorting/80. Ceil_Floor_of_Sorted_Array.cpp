#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);

    cout << "Enter array elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int left = 0, right = n - 1;
    int x;
    cout << "Enter Value: ";
    cin >> x;

    int floor = -1, ceil = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == x) {
            cout << "Floor = " << arr[mid] << ", Ceil = " << arr[mid] << endl;
            return 0;
        } else if (arr[mid] > x) {
            ceil = arr[mid];
            right = mid - 1;
        } else {
            floor = arr[mid];
            left = mid + 1;
        }
    }

    cout << "Floor = " << (floor == -1 ? "Doesn't exist" : to_string(floor))
         << ", Ceil = " << (ceil == -1 ? "Doesn't exist" : to_string(ceil)) << endl;

    return 0;
}
