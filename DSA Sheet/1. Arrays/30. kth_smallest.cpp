#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n1 ;
    cin >> n1;
    vector<int> arr1(n1);
    for(int i=0; i<n1; i++)
    {
        cin>>arr1[i];
    }
    int k ;
    cout<<"Which do u want " << k << " smallest : ";
    cin>>k; 
    sort(arr1.begin() , arr1.end());
    cout<<"The smallest kth is "<<arr1[k-1];


    
}