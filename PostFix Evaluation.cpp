#include<iostream>
#include<stack>
#include<math.h>
using namespace std;
int postfixEvaluation(string s)
{
	stack<int> st;
	for(int i=0; i<s.length(); i++)
	{
		if(s[i] >= '0' && s[i] <= '9')
		{
			st.push(s[i] - '0'); //For Converting Integer
		}
		else
		{
			int operator2 = st.top();
			st.pop();
			int operator1 = st.top();
			st.pop();
			switch(s[i])
			{
				case '+':
					st.push(operator1 + operator2);
					break;
				case '-':
					st.push(operator1 - operator2);
					break;	
				case '*':
					st.push(operator1 * operator2);
					break;
				case '/':
					st.push(operator1 / operator2);
					break;
				case '^':
				    st.push(pow(operator1,operator2));
					break;
		}
	}
	
}
return st.top();
}
int main()
{
	
	cout<<postfixEvaluation("48+2/5*7+");
}