#include<iostream>
using namespace std ;
struct Node 
{
	int data ;
	Node* next;
};
class CLL
{
	private:
		Node* head ;
		Node* tail ;
	public:
		CLL()
		{
			head = nullptr ;
			tail = nullptr ;
		}
	
	// Insert Nodes in Circular Linked List
	
	void insert(int val)
	{
		Node* newnode = new Node();
		newnode->data = val ;
		if(head == nullptr )
		{
			head = newnode ;
			tail = newnode ;
			return ;
		}
		tail->next = newnode ;
		newnode->next = head ;
		tail =  newnode ;
	}	
	
//	Display All Nodes 
	
	void display()
	
	{
		Node* current = head ;
		if(current != nullptr )
		{
			do{
				cout<<current->data<<" -> ";
				current =  current->next;
			}while(current != head );
		}
		
	}
	
	// Deletion in CLL
	
	void deletenode(int val)
	{
		if(head == nullptr)
		{
		 return;
		}
		if(head->data == val)
		{
			head = head->next;
			tail->next = head ;
			return ;
		}
		Node* current = head ;
		do{
			Node* nextnode = current->next ;
			if(nextnode->data == val)
			{
				current->next = nextnode->next;
				break;
			}
			current = current->next;
		}while(current != head );
	}
	
	
};
int main()
{
	CLL list ;
	list.insert(10);
	list.insert(20);
	list.insert(30);
	list.display();
	cout<<"\nAfter Delete the Nodes \n";
	list.deletenode(30);
	list.display();
}