#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n ;
    cin >> n;
    int arr[n];
    int sum = 0;
    for(int i=0; i<n; i++)
    {
        cin>>arr[i];
        sum += arr[i];
    }
    int slow = arr[0];
    int fast = arr[0];
    do{
    slow = arr[slow];
    fast = arr[arr[fast]];    
	}while(slow != fast);
	fast = arr[0];
	while(slow != fast)
	{
		slow = arr[slow];
		fast = arr[fast];
	};
	int sum1 = (n*(n+1)) / 2;
	cout<<"The number missing in there is : "<<sum1 - (sum - slow); 


}