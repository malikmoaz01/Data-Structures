#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

vector<int> findUnion(int arr1[], int size1, int arr2[], int size2) {
    unordered_set<int> set1(arr1, arr1 + size1); // Pehle array ke elements ko set mein daal diya

    // Dusre array ke elements ko bhi set mein daal do (jo elements set mein already nahi hain, wo add ho jayenge)
    for (int i = 0; i < size2; i++) {
        set1.insert(arr2[i]);
    }

    // Set ke elements ko vector mein daal diya
    vector<int> unionSet(set1.begin(), set1.end());

    return unionSet;
}

int main() {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {3, 4, 5, 6, 7};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    int size2 = sizeof(arr2) / sizeof(arr2[0]);

    vector<int> unionSet = findUnion(arr1, size1, arr2, size2);

    cout << "Union of arrays: ";
    for (int i : unionSet) {
        cout << i << " ";
    }

    return 0;
}