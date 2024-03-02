#include<iostream>
#include<stack>
using namespace std;
void last_element(stack<int> &st , int element )
{
	if(st.empty())
	{
		st.push(element);
		return;
	}
	int insertele = st.top();
	st.pop();
	last_element(st,element);
	st.push(insertele);
}

void reverse(stack<int> &st)
{
	if(st.empty())
	{
		return;
	}
	int element = st.top(); // 5 ko nikal dya
	st.pop();
	reverse(st);
	last_element(st,element);
}
int main()
{
	stack<int> st;
	st.push(10);
	st.push(25);
	st.push(36);
	st.push(48);
	st.push(50);
	cout<<"Element are ";
	reverse(st);
	while(!st.empty())
	{
		cout<<st.top()<<endl;
		st.pop();
	}
	cout<<endl;
}