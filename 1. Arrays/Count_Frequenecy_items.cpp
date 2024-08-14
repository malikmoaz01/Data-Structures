#include<iostream>
using namespace std;
int main()
{
    int arr[8] = {1,2,2,1,1,2,5,2};
    int n = sizeof(arr) / sizeof(arr[0]);
    int count;
    bool previous_visited[8] = {false};
    
    for(int i=0; i<n; i++)
    {
        if(previous_visited[i] == true)
        {
            continue;
        }
        count = 1;  
        for(int j=i+1; j<n; j++)
        {
            if(arr[i] == arr[j])
            {
                previous_visited[j] = true;
                count++;
            }
        }
        cout << arr[i] << " " << count << "\n";
    }
}
