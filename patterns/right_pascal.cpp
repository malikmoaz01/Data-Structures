#include<iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter the number of rows: ";
    cin >> n;
	cout<<"\n";
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
        	if(j <= n-i)
        	{
			
            cout<<" ";
        }
        else
        {
        	cout<<"*";
		}
    }
    cout << "\n";
}
    
    return 0;
}
