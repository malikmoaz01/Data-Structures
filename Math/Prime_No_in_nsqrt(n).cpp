#include<iostream>
using namespace std;

bool prime(int n)
{
	int c = 2;
	// sqrt(n) 
	while(c * c <= n)
	{
		if(n % c == 0)
		{
			return false;
		}
		c++;
	}
	return true;
}

int main()
{
	int n = 40;
	// O(n)
	for(int i = 2; i <= n; i++)
	{
		if(prime(i))
		{
			cout << i << " ";
		}
	}
	return 0;
}
