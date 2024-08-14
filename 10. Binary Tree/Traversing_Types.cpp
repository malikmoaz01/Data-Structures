#include<iostream>
#include<queue> 
using namespace std;

struct Node 
{
	int value;
	Node* left;
	Node* right;
	Node(int val)
	{
		value = val;
		left = nullptr;
		right = nullptr;
	}
};

void PreOrder(Node* node)
{
	if (node == nullptr)
	{
		return;
	}
	cout << node->value << " -> ";
	PreOrder(node->left);
	PreOrder(node->right);
}

void Inorder(Node* node)
{
	if (node == nullptr)
	{
		return;
	}
	Inorder(node->left);
	cout << node->value << " -> ";
	Inorder(node->right);
}

void PostOrder(Node* node)
{
	if (node == nullptr)
	{
		return;
	}
	PostOrder(node->left);
	PostOrder(node->right);
	cout << node->value << " -> ";
}

void LevelOrderTraversal(Node* root)
{
	if (root == nullptr)
	{
		return;
	}

	queue<Node*> q;
	q.push(root);

	while (!q.empty())
	{
		Node* node = q.front();
		q.pop();
		cout << node->value << " -> ";

		if (node->left != nullptr)
		{
			q.push(node->left);
		}
		if (node->right != nullptr)
		{
			q.push(node->right);
		}
	}
}

int main()
{
	Node* root = new Node(1);
	root->left = new Node(2);
	root->right = new Node(3);
	root->right->left = new Node(6);
	root->right->right = new Node(7);
	root->left->left = new Node(4);
	root->left->right = new Node(5);
	root->left->left->left = new Node(8);
	root->left->left->right = new Node(9);

	cout << "Pre Order Traversing is:\n";
	PreOrder(root);

	cout << "\n\nInorder Traversing is:\n";
	Inorder(root);

	cout << "\n\nPostOrder Traversing is:\n";
	PostOrder(root);

	cout << "\n\nLevelOrder Traversing is:\n";
	LevelOrderTraversal(root);

	return 0;
}
