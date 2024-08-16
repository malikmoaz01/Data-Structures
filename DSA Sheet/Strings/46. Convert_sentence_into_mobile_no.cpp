#include<bits/stdc++.h>
using namespace std ;
int main()
{
    string input;
    cin>>input;
    string str[] = { "2", "22", "222", "3", "33", "333", "4",
            "44", "444", "5", "55", "555", "6", "66",
            "666", "7", "77", "777", "7777", "8", "88",
            "888", "9", "99", "999", "9999" };
    
    string output ;
    for(int i=0; i<input.size(); i++)
    {
        if(input == " ")
        {
            output += "0";
        }else{
            int position = input[i] - 'A' ;
            output += str[position];
        }
    }
    cout<<output;
}