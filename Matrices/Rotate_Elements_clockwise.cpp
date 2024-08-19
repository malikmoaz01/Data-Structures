#include <iostream>
using namespace std;

void rotateClockwise(int matrix[3][3]) {
    int temp[3][3];

    
}

void printMatrix(int matrix[3][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    int matrix[3][3] = { 
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 9} 
    };

    cout << "Original Matrix:" << endl;
    printMatrix(matrix);

    rotateClockwise(matrix);

    cout << "\nRotated Matrix:" << endl;
    printMatrix(matrix);

    return 0;
}
