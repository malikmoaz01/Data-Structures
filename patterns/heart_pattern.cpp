#include<iostream>
using namespace std;
int main()
{
	int n ;
	cin>> n;
    int i, j;
    
    
    for (i = 1; i <= n; i++)
    {		
		for(int j =1 ; j<=n ; j++)
		{
			if(i == 4 && j == 2)
			{
				cout<<"*";
			}
			else if(i == 4 && j == 3)
			{
				cout<<"*";
			}
			else if((i == n) && (j == n))
			{
				cout<<" ";
			}
			else if(i == n)
			{
				cout<<"*";
			}
			else 
			{
				cout<<" ";
			}
		}
        cout << "\n";
    }
    
    // Lower Heart
    
    for (i = n; i >= 1; i--)
    {		
		// Pyramid Pattern 
    	
    	for(int j =1; j <= n; j++)
    	{
    		if( j <= n - i )
    		{
    			cout<<" ";
			}
			else 
			{
				cout<<"*";
			}
		}
        for (j = 2; j <= i; j++)
        {
                cout<<"*";
        }
        cout << "\n";
    }
    
    
    return 0;
}
