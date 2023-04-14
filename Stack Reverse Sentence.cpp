//#include<bits/stdc++.h>
//Reverse A Sentence using Stack
#include<iostream>
#include<stack>
using namespace std;
void reversesentence(string s)
{
	stack<string> st;
	string words;
	for(int i=0; i<s.length(); i++)
	{
			string words;
			while( s[i]!=' ' && i < s.length())
			{
				words += s[i];
				i++;
			}
			st.push(words);
	}
	while(!st.empty())
	{
		cout<<st.top()<<" ";
		st.pop();
	}
	cout<<endl;
};

int main()
{
	string s="Name my is Moaz Malik";
    reversesentence(s);
}
