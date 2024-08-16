#include <bits/stdc++.h>
#include <math.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int n1;
    cin>>n1;

    int n2 ;
    cin>>n2;

    vector<int> arr(n);
    vector<int> arr1(n);
    vector<int> arr2(n);

    
    cout << "Enter array 1 elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << "Enter array 2 elements: ";
    for (int i = 0; i < n1; i++) {
        cin >> arr1[i];
    }

    cout << "Enter array 3 elements: ";
    for (int i = 0; i < n2; i++) {
        cin >> arr2[i];
    }

    int size = min(n , n1 );
    int size1 = min(size ,n2);
    
    for(int i=0; i<size1; i++)
    {
        if(arr[i] == arr1[i] && arr1[i] == arr2[i])
        {
            cout<<"Common Element are : "<<arr[i];
            i++;
        }
    }

}
