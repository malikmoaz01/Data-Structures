#include<iostream>
using namespace std;

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
