#include<iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

class LinkedList {
private:
    Node* head;
public:
    LinkedList() {
        head = nullptr;
    }

	
	
	void insertatanyposition(int value , int position)
	
	{
		Node* newnode = new Node();
		newnode->data =  value ;
		if(position < 1)
		{
			cout<<"Position should not be in negative \n";
			return ;
		}
		if(position == 1)
		{
			newnode->next = head ;
			head = newnode;
			return ;
		}
		
		Node* current =  head ;
		int count = 1;
		while(current != nullptr && count < position - 1 )
		{
			current = current->next;
			count++;
		}
		if(current == nullptr)
		{
			cout<<"Out of Bound \n";
			return ;
		}
		newnode->next = current->next;
		current->next = newnode ;
		
	}
	
	// Print Linked List 
	
	void print()
	{
		if(head == nullptr)
		{
			cout<<"Linked List is Empty"<<"\n";
			return ;
		}
		Node* currentnode = head ;
		while(currentnode != nullptr)
		{
			cout<<currentnode->data<<"->";
			currentnode = currentnode->next;
		}
		cout<<"Null\n";
	}
	
	// Remove Duplicate & return sorted Linked List 
	
	void remove_duplicate()
	{
		if(head == nullptr)
		{
			return;
		}
		Node* current = head ;
		while(current != nullptr && current->next != nullptr)
		{
			if(current->data == current->next->data)
			{
				Node* temp = current->next ;
				current->next = current->next->next ;
				delete temp ;
				break;
			}
			else 
			{
				current = current->next ;
			}
		}
	}
	


	
};

int main() {
    LinkedList list;
    list.insertatanyposition(10,1);
    list.insertatanyposition(20,2);
    list.insertatanyposition(30,3);
	list.insertatanyposition(30,3);
	list.remove_duplicate();
    list.print();
    return 0;
}