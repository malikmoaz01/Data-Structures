#include <bits/stdc++.h>
using namespace std;
int main()
{
    
    string s1 = "islnet";
    string s2 = "listen";
    sort(s1.begin() , s1.end());
    sort(s1.begin() , s2.end());
    if(s1.size() != s2.size()) return false ;
    for(int i=0 ; i<s1.size(); i++)
    {
        if(s1[i] != s2[i])
        {
            cout<<"Not Anagaram "
        }
    }
    return true ;
}