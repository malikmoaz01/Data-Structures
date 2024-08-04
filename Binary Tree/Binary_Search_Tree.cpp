#include <iostream>
using namespace std;

class Node {
public:
    int value;
    Node* left;
    Node* right;

    Node(int val) {
        value = val;
        left = nullptr;
        right = nullptr;
    }

    Node* insert(Node* root, int val) {
        if (root == nullptr) {
            return new Node(val);
        }
        if (root->value > val) {
            root->left = insert(root->left, val);
        } else {
            root->right = insert(root->right, val);
        }
        return root;
    }

    void Inorder(Node* node) {
        if (node == nullptr) {
            return;
        }
        Inorder(node->left);
        cout << node->value << " -> ";
        Inorder(node->right);
    }

    Node* search(Node* root, int key) {
        if (root == nullptr || root->value == key) {
            return root;
        }
        if (root->value > key) {
            return search(root->left, key);
        } else {
            return search(root->right, key);
        }
    }

    Node* findMin(Node* node) {
        while (node->left != nullptr) {
            node = node->left;
        }
        return node;
    }

    Node* deleteNode(Node* root, int key) {
        if (root == nullptr) {
            return nullptr;
        }

        if (key < root->value) {
            root->left = deleteNode(root->left, key);
        } else if (key > root->value) {
            root->right = deleteNode(root->right, key);
        } else {
            if (root->left == nullptr) {
                return root->right;
            } else if (root->right == nullptr) {
                return root->left;
            }

            Node* temp = findMin(root->right);
            root->value = temp->value;
            root->right = deleteNode(root->right, temp->value);
        }
        return root;
    }

    void printInRange(Node* node, int x, int y) {
        if (node == nullptr) {
            return;
        }
        if (node->value > x) {
            printInRange(node->left, x, y);
        }
        if (node->value >= x && node->value <= y) {
            cout << node->value << " -> ";
        }
        if (node->value < y) {
            printInRange(node->right, x, y);
        }
    }

    void display(Node* node, int level = 0) {
        if (node == nullptr) {
            return;
        }
        display(node->right, level + 1);
        cout << endl;
        for (int i = 0; i < level; i++) {
            cout << "   ";
        }
        cout << node->value;
        display(node->left, level + 1);
    }
};

int main() {
    int size;
    cout << "Enter the number of elements: ";
    cin >> size;
    
    int arr[size];
    cout << "Enter the elements: ";
    for (int i = 0; i < size; i++) {
        cin >> arr[i];
    }

    Node* root = nullptr;
    Node tree(0);

    for (int i = 0; i < size; i++) {
        root = tree.insert(root, arr[i]);
    }

    cout << "\n\nInorder Traversing is:\n";
    tree.Inorder(root);

    int deleteKey;
    cout << "\nEnter the key to delete: ";
    cin >> deleteKey;
    root = tree.deleteNode(root, deleteKey);

    cout << "\nInorder Traversing after deletion:\n";
    tree.Inorder(root);

    int x = 6, y = 10;
    cout << "\nNodes in range [" << x << ", " << y << "] are:\n";
    tree.printInRange(root, x, y);

    cout << "\n\nTree Structure:\n";
    tree.display(root);

    return 0;
}
