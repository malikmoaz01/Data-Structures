#include<iostream>
using namespace std ;
int count_zeros(int n , int count)
{
	if(n == 0)
	{
		return count;
	}
	if(n%10 == 0)
	{
		count++ ;
	}
		return count_zeros(n/10,count);
}
int main()
{
	int n = 30204;
	cout<<count_zeros(n,0);
}