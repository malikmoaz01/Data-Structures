#include<iostream>
using namespace std;
int main()
{
	int n ;
	cin>> n;
    int i, j;
    for (i = n ; i >= 1 ; i--)
    {
    	for(int j = 1; j < n; j++)
    	{
    		if( j <=  n -i )
    		{
    			cout<< " ";
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
