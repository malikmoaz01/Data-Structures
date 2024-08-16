#include<bits/stdc++.h>
using namespace std ;
int main()
{
    string s = "maalikmoaz";
    sort(s.begin() , s.end());
    int count ;
    int len = s.size();
    for(int i=0; i<s.size(); i++)
    {
        count =  1;
        while ( i < len - 1 && s[i] == s[i+1])
        {
            count++;
            i++;
        }
        if(count > 1)
        {
        cout<<"The count of "<<s[i]<< " is : "<<count <<endl;
        }
    }
}