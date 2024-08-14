#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

vector<int> findIntersection(int arr1[], int size1, int arr2[], int size2) {
    unordered_set<int> set1(arr1, arr1 + size1); // Pehle array ke elements ko set mein daal diya
    vector<int> intersection;

    for (int i = 0; i < size2; i++) {
        if (set1.find(arr2[i]) != set1.end()) {
            intersection.push_back(arr2[i]); // Agar element dusre array mein bhi hai tou intersection mein add kar do
            set1.erase(arr2[i]); // Duplicate elements ko avoid karne ke liye isse remove kar do
        }
    }

    return intersection;
}

int main() {
    int arr1[] = {1, 2, 3, 4, 5};
    int arr2[] = {3, 4, 5, 6, 7};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);
    int size2 = sizeof(arr2) / sizeof(arr2[0]);

    vector<int> intersection = findIntersection(arr1, size1, arr2, size2);

    cout << "Intersection of arrays: ";
    for (int i : intersection) {
        cout << i << " ";
    }

    return 0;
}