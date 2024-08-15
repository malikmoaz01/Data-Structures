#include <iostream>
#include <string> 
using namespace std;

int main() {
    int count = 1;
    int maxcount = 1;
    string str;
    cin >> str;
    
    for (long unsigned int i = 0; i < str.size(); i++) {
    	
        if (str[i] == str[i + 1]) {
        	count++;
            if(maxcount < count )
            {
        		maxcount = count ;
			}
        }else{
        	count = 1;
		}
    }
    
    cout << maxcount;
    return 0;
}
