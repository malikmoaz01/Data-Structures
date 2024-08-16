#include<bits/stdc++.h>
using namespace std ;
int main()
{
	int n ;
	cin>>n;
	vector<int> arr(n);
    for(int i=0;  i<n; i++)
    {
        cout<<"Enter value "<<i+1<<" : ";
        cin>>arr[i];
    }
    sort(arr.begin(), arr.end());
    int k;
    cout<<"Number of Chocolates : ";
    cin>>k;
    int max = INT_MIN;
    int min = INT_MAX;
    for(int i=0; i<k; i++)
    {
        if(max < arr[i])
        {
            max = arr[i];
        }
    } 
    for(int i=0; i<k; i++)
    {
        if(min > arr[i])
        {
            min = arr[i];
        }
    } 
    cout<<max - min ;

}