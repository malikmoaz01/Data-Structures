#include<iostream>
using namespace std;

struct Node {
	
    int value;
    Node* left;
    Node* right;
    Node(int val) {
        value = val;
        left = nullptr;
        right = nullptr;
    }
    
    
};

class Binary_Tree {
	
	
public:
    Node* root;
    Binary_Tree() {
        root = nullptr;
    }

    void root_val() {
        int val;
        cout << "Enter root value: ";
        cin >> val;
        root = new Node(val);
    }





    void populate(Node* node) {
        if(node == nullptr) {
            return;
        }

        cout << "For left -> (1 for Yes, 0 for No) " << node->value <<  : ;
        bool left;
        cin >> left;
        if(left) {
            int left_value;
            cout << "Enter left value of " << node->value << ": ";
            cin >> left_value;
            node->left = new Node(left_value);
            cout << "Left Value Done\n";
            populate(node->left);
        }
        
		cout << "For Right -> (1 for Yes, 0 for No) " << node->value << " : ";
        bool right;
        cin >> right;
        if(right) {
            int right_value;
            cout << "Enter right value of " << node->value << ": ";
            cin >> right_value;
            node->right = new Node(right_value);
            cout << "Right Value Done\n";
            populate(node->right);
        }
    }



    void display(Node* node) {
        if (node == nullptr) {
            return;
        }
        display(node->left);
        cout << node->value << " ";
        display(node->right);
    }
    
    
    
    
};

int main() {
	
    Binary_Tree tree;
    tree.root_val();
    tree.populate(tree.root); 
    tree.display(tree.root); 
    




    cout << "\nRoot Node: " << tree.root->value << endl;
    
    if(tree.root->left != nullptr) {
        cout << "Left Child of Root: " << tree.root->left->value << endl;
    } else {
        cout << "Left Child of Root: None" << endl;
    }
    
    if(tree.root->right != nullptr) {
        cout << "Right Child of Root: " << tree.root->right->value << endl;
    } else {
        cout << "Right Child of Root: None" << endl;
    }

    return 0;

}
