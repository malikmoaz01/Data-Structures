#include<iostream>
using namespace std;
int main()
{
	int n ;
	cin>> n;
    int i, j;
    for (i = 1; i<=n ; i++)
    {
    	for(j = 1; j < n ; j++)
    	{
    		if(j <= n -i)
    		{
    			cout<<" ";
			}
			else 
			{
				cout<<"*";
			}
		}
		for(int j = 1 ; j<= i; j++)
    	{
				cout<<"*";
		}
        cout << "\n";
    }
    
	for (i = n-1; i>=1 ; i--)
    
	{
    	for(j = 1; j < n ; j++)
    	{
    		if(j <= n -i)
    		{
    			cout<<" ";
			}
			else 
			{
				cout<<"*";
			}
		}
		for(int j = 1 ; j<= i; j++)
    	{
				cout<<"*";
		}
        cout << "\n";
    }
    return 0;
}
