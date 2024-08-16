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

    sort(arr.begin(), arr.end());

    int left = 0, right = n - 1;
    int dif;
    cin >> dif;
    bool found = false;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        int largest = arr[n - 1];
        int currentDiff = largest - arr[mid];

        if (currentDiff == dif) {
            found = true;
            break;
        } else if (currentDiff < dif) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    if (found) {
        cout << "Difference is found\n";
    } else {
        cout << "Difference is not found\n";
    }

    return 0;
}
