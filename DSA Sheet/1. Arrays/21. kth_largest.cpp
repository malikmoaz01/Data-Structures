#include <bits/stdc++.h>
using namespace std;
int main() 

{
    int n;
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sort(arr.begin(), arr.end(), greater<int>());
    int k;
    cout << "Which Kth largest do you want: ";
    cin >> k;
    cout << "The " << k << "th largest is " << arr[k-1] << endl;

    return 0;
}
