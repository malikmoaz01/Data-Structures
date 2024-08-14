#include<iostream>
using namespace std;

// Simple funda ye ha isme ju prime mil gya oske multiples remove krdu 
// Yani agr 2 hain tu 4 , 6 , 8 , 10 till 40 tak check krne ki zarorat nhi ha 
// Time Complexity is O(nloglogn)
// Space Complexity is O(n) because we take an extra array prime

void sieve(int n, bool* primes)
{
	for(int i = 2; i * i <= n; i++)
	{
		// if false, then it's a prime number
		if(!primes[i])
		{
			for(int j = i * 2; j <= n; j += i)
			{
				primes[j] = true;
			}
		}
	}
	for(int i = 2; i <= n; i++)
	{
		if(!primes[i])
		{
			cout << i << " is " << "Prime Number" << endl;
		}
	}
}

int main()
{
	int n = 40;
	bool* primes = new bool[n + 1]{false}; 
	sieve(n, primes);
	delete[] primes; 
	return 0;
}
