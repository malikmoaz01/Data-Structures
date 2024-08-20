#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    // sort(arr.begin() , arr.end());
    
    cout << "Enter array 1 elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int k ;
    cout<<"steps : ";
    cin>>k;
    int x;
    cout<<"Enter find value ";
    cin>>x;
    for(int i=0; i<n; i++)
    {
        if(x == arr[i])
        {
            cout<<i;
        }
    }

}