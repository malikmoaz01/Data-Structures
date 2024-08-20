#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> arr(n);
    vector<int> arr1(n);
    
    cout << "Enter array 1 elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Enter array 2 elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr1[i];
    }
    
    int k;
    cout << "Enter k value: ";
    cin >> k;

    sort(arr.begin(), arr.end());
    sort(arr1.begin(), arr1.end(), greater<int>());
    bool possible = true;
    for (int i = 0; i < n; i++) {
        if (arr[i] + arr1[i] < k) {
            possible = false;
            break;
        }
    }

    if (possible) {
        cout << "Yes\n";
    } else {
        cout << "No\n";
    }
    
    return 0;
}
