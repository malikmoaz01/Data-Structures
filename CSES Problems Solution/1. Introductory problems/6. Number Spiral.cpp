#include <iostream>
using namespace std;

int main() {
    int t;
    cin>>t;
    while(t--)
    {
	int arr[5][5] = {
        {1, 2, 9 , 10 , 25},
        {4 , 3 , 8 , 11 , 24},
        {5 , 6 , 7 , 12 , 23},
        {16 , 15 , 14 , 13 , 22},
        {17 , 18 , 19 , 20 , 21} };
    	int rows , cols;
    	cin>>rows>>cols;
    	int index_row = rows - 1;
        int index_cols = cols - 1;
    	cout<<arr[index_row][index_cols];
	}
		return 0;
}
