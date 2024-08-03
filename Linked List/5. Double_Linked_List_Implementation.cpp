#include<iostream>
using namespace std ;
struct Node{
	int val ;
	Node* next ;
	Node* prev;
};
class DLL
{
	private:
		Node* head ;
	public: 
	DLL()
	{
		head = nullptr ;
	}
	void insertAtfirst(int value)
	{
		Node* newnode = new Node();
		newnode->val = value ;
		newnode->next =  head ;
		newnode->prev = nullptr;
		if(head != nullptr)
		{
			head->prev = newnode;
		}
		head =  newnode ;
	}
	void insertAtLast(int value)
	{
		Node* newnode = new Node();
		newnode->val = value ;
		if(head == nullptr )
		{
			head = newnode ;
			return ;
		}
		Node* current = head;
		while(current->next != nullptr)
		{
			current = current->next;
		}
		newnode->next = nullptr;
		current->next = newnode;
		newnode->prev = current;
		
	}
	void display()
	{
		Node* current =  head ;
		while(current != nullptr)
		{
			cout<<current->val<<" -< ";
			current =  current->next;
		}
		cout<<" NULL \n";
	}
	void display_reverse()
	{
		Node* current =  head ;
		Node* last = nullptr ;
		while(current != nullptr)
		{
			cout<<current->val<<" -< ";
			last = current ;
			current =  current->next;
		}
		cout<<" NULL \n";
		while(last !=  nullptr )
		{
			cout<<last->val<<" -< ";
			last = last->prev;
		}
		cout<<" START \n";
	}
	
	// Delete At First 
	
	void deleteAtFirst()
	{
		Node* temp = head ;
		head =  head->next ;
		delete temp ;
	}
	
	void deleteLast()
	{
		if(head == nullptr)
		{
			cout<<"List is Empty";
			return;
		}
		if(head->next == nullptr)
		{
			delete head ;
			head->next = nullptr ;
			return ;
		}
		Node* current = head ;
		while(current->next != nullptr)
		{
			current = current->next;
		}
		current->prev->next = nullptr;
    	delete current;
	}
	
	
	
};
int main()
{
	DLL list ;
	list.insertAtfirst(10);
	list.insertAtfirst(20);
//	list.display();
//	list.deleteAtFirst();
//	list.display_reverse();
//	cout<<"\nAt Last Insertion\n";
//	list.insertAtLast(30);
//	list.deleteLast();
	list.display();
}