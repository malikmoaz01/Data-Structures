#include<iostream>
using namespace std;
int main()
{
	int n ;
	cin>> n;
    int i, j;
    for (i = 1; i <= n; i++)
    {
        for(j = 1 ; j <= n ; j++)
        {
        	if (j <=  n - i)
        	{
        		cout<<" ";
			}
			else 
			{
				cout<<"*";
			}
			
		}
		for(int k = 1; k <= n+1-i; ++k)
		{
			cout<<"*";
		}
	    cout<<"\n";
    }
    for (i = n; i >= 1; i--)
    {
        for(j = 1 ; j <= n ; j++)
        {
        	if (j <=  n - i)
        	{
        		cout<<" ";
			}
			else 
			{
				cout<<"*";
			}
			
		}
		
		for(int k = 1; k <= n+1-i; ++k)
		{
			cout<<"*";
		}
	    cout<<"\n";
    }
    return 0;
}
