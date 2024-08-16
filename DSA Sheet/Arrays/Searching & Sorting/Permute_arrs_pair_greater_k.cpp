#include <bits/stdc++.h>
using namespace std ;
int main()
{
    int n ;
    vector<int> arr(n);
    int n1;
    vector<int> arr1(n1);

    cout << "Enter array 1 elements :  ";
    for(int i=0; i<n; i++)
    {
        
        cin>>arr[i];
    }

    cout << "Enter array 2 elements :  ";
    for(int i=0; i<n1; i++)
    {
        cin>>arr1[i];
    }

    sort(arr.begin() , arr.end());
    sort(arr1.begin() , arr1.end() , greater<int>);

    int k ;
    cout<<"Enter k value ";
    cin>>k ;
    
    for(int i=0 ;)

}