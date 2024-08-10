#include<iostream>
using namespace std ;
struct Node 
{
	int data ;
	Node* next;
};
class LinkedList
{
	private:
		Node* head ;
	public:
		LinkedList() { head = nullptr; };
	void InsertFirst(int data)
	{
        Node* newnode = new Node();
        newnode->data = data;
        newnode->next = head;
        head = newnode;
	}
	void print()
	{
		
		Node* current = head ;
		if(head ==  nullptr)
		{
			cout<<"LL is empty\n";
			return;
		}
		while (current != nullptr)
		{
			cout<<current->data<<" -> ";
			current =  current->next;
		}
	}
	//Iterative 
	void iterative_reverse()
		{
	 	if(head == nullptr && head->next ==  nullptr)
	 	{
	 		return;
		}
		Node* prev = nullptr ;
		Node* current = head ;
		Node* next ;
		while(current != nullptr)
		{
			next = current->next;
			current->next = prev;
			prev = current ;
			current = next;
		}
		head = prev ;
	}
	Node* recursive_reverse_helper(Node* current)
	{
		if (current == nullptr || current->next == nullptr) {
			return current;
		}

		Node* newhead = recursive_reverse_helper(current->next);
		current->next->next = current;
		current->next = nullptr;

		return newhead;
	}
	// Recursive 
	void recursive_reverse()
	{
		head = recursive_reverse_helper(head);
	}
};
int main()
{
	LinkedList list ;
	list.InsertFirst(10);
	list.InsertFirst(20);
	list.InsertFirst(30);
	list.InsertFirst(40);
	list.print();
	cout<<"\n";
	list.iterative_reverse();
	list.print();
	cout<<"\n";
	list.recursive_reverse();
	list.print();
}